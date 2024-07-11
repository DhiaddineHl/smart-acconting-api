package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.repositories.TokenRepository;
import com.wind.windrecruitmentapi.repositories.UserRepository;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.AuthenticationService;
import com.wind.windrecruitmentapi.utils.authentication.TokenType;
import com.wind.windrecruitmentapi.utils.authentication.*;
import com.wind.windrecruitmentapi.utils.authorization.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public void verifyUser(String email){
        Optional<User> user =  repository.findByEmail(email);
        if (user.isPresent()){
            throw new IllegalStateException("Email already taken");
        }
    }
    @Override
    public AuthResponse registerCandidate(CandidateRegisterRequest request) {

        verifyUser(request.getEmail());

        var candidate = Candidate.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .university(request.getUniversity())
                .role(UserRole.CANDIDATE)
                .build();

        var savedUser = repository.save(candidate);
        String jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser,jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse registerManager(ManagerRegisterRequest request) {
        verifyUser(request.getEmail());

        EnterpriseManager hrRecruiter = EnterpriseManager.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.MANAGER)
                .build();

        var savedUser = repository.save(hrRecruiter);
        String jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser,jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse registerHRRecruiter(ManagerRegisterRequest request) {
        verifyUser(request.getEmail());

        HRRecruiter hrRecruiter = HRRecruiter.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.RECRUITER)
                .build();

        var savedUser = repository.save(hrRecruiter);
        String jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser,jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }

    @Override
    public AuthResponse registerTechRecruiter(ManagerRegisterRequest request) {
        verifyUser(request.getEmail());

        TechnicalRecruiter technicalRecruiter = TechnicalRecruiter.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .company(request.getCompany())
                .role(UserRole.RECRUITER)
                .build();

        var savedUser = repository.save(technicalRecruiter);
        String jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser,jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
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
        saveUserToken(user, jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }


    public void saveUserToken(User appUser, String jwtToken) {
        Token token = Token.builder()
                .user(appUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public AuthResponse register(RegisterRequest request) {

        var user = User.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone_number(request.getPhone_number())
                .build();

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(savedUser);
        saveUserToken(savedUser,jwtToken);

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }
}
