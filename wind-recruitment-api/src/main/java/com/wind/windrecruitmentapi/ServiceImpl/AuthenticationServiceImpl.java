package com.wind.windrecruitmentapi.ServiceImpl;

import com.wind.windrecruitmentapi.entities.*;
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
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Value("${spring.application.mailing.frontend.activation_url}")
    private String activation_url;

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
        sendVerificationEmail(candidate);

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
        sendVerificationEmail(manager);

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

        return AuthResponse.builder()
                .access_token(jwtToken)
                .build();
    }

    @Override
    public void activateAccount(String token) throws MessagingException {

        Token savedToken = tokenRepository.findByToken(token);

        if (LocalDateTime.now().isAfter(savedToken.getExpiresAt())) {
            sendVerificationEmail(savedToken.getUser());
            throw new RuntimeException("Activation token has expired. A new token has been send to the same email address");
        }

        User user = repository.findById(savedToken.getUser().getId())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setAccountActivated(true);
        repository.save(user);

        savedToken.setValidatedAt(LocalDateTime.now());
        tokenRepository.save(savedToken);
    }


    public void sendVerificationEmail(User user) throws MessagingException {
        String verificationToken = generateAndSaveVerificationToken(user);
        //send email
        emailService.sendEmail(
                user.getEmail(),
                user.getFirst_name() + user.getLast_name(),
                EmailTemplateName.ACTIVATE_ACCOUNT,
                activation_url,
                verificationToken,
                "Account activation"
        );
    }

    private String generateAndSaveVerificationToken(User user) {

        String generatedCode = generateVerificationCode(6);

        Token token = Token.builder()
                .token(generatedCode)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15))
                .user(user)
                .build();
        tokenRepository.save(token);

        return generatedCode;
    }

    private String generateVerificationCode(int length) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

}
