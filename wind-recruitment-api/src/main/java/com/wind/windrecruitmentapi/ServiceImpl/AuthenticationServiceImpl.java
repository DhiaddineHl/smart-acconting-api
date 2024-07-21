package com.wind.windrecruitmentapi.ServiceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.repositories.ConfirmationTokenRepository;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.UserRepository;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.AuthenticationService;
import com.wind.windrecruitmentapi.utils.authentication.TokenType;
import com.wind.windrecruitmentapi.utils.authentication.*;
import com.wind.windrecruitmentapi.utils.authorization.UserRole;
import com.wind.windrecruitmentapi.utils.email.EmailService;
import com.wind.windrecruitmentapi.utils.email.EmailTemplateName;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final AuthenticationUtils authenticationUtils;


    public void verifyUser(String email){
        Optional<User> user =  repository.findByEmail(email);
        if (user.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
    }
    @Override
    public void registerCandidate(CandidateRegisterRequest request) throws MessagingException {

//        verifyUser(request.getEmail());

        var candidate = Candidate.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .university(request.getUniversity())
                .role(UserRole.CANDIDATE)
                .isAccountActivated(false)
                .build();

        repository.save(candidate);
        authenticationUtils.sendVerificationEmail(candidate);

    }

    @Override
    public void registerManager(ManagerRegisterRequest request) throws MessagingException {
        verifyUser(request.getEmail());

        EnterpriseManager manager = EnterpriseManager.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.MANAGER)
                .isAccountActivated(false)
                .build();

        repository.save(manager);
        authenticationUtils.sendVerificationEmail(manager);

    }

    @Override
    public void registerHRRecruiter(ManagerRegisterRequest request) {
        verifyUser(request.getEmail());

        HRRecruiter hrRecruiter = HRRecruiter.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.RECRUITER)
                .isAccountActivated(true)
                .build();

        repository.save(hrRecruiter);

    }

    @Override
    public void registerTechRecruiter(ManagerRegisterRequest request) {
        verifyUser(request.getEmail());

        TechnicalRecruiter technicalRecruiter = TechnicalRecruiter.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.RECRUITER)
                .isAccountActivated(true)
                .build();

        repository.save(technicalRecruiter);

    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(()-> new BadCredentialsException("Invalid email or password"));

        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        //todo: add the token saving method

        return AuthResponse.builder()
                .access_token(jwtToken)
                .refresh_token(refreshToken)
                .build();
    }

    @Override
    public void activateAccount(String token) throws MessagingException {

        ConfirmationToken savedToken = confirmationTokenRepository.findByToken(token);

        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            authenticationUtils.sendVerificationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }

        User user = repository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setAccountActivated(true);
        repository.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        confirmationTokenRepository.save(savedToken);
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            throw new IllegalStateException("Bad request");
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            User user = this.repository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);

                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);

                AuthResponse authResponse = AuthResponse.builder()
                        .access_token(accessToken)
                        .refresh_token(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .type(TokenType.BEARER)
                .isExpired(false)
                .isRevoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


}
