package com.wind.windrecruitmentapi.utils.authentication;


import com.wind.windrecruitmentapi.entities.User;
import com.wind.windrecruitmentapi.utils.email.EmailService;
import com.wind.windrecruitmentapi.utils.email.EmailTemplateName;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationUtils {

//    private final EmailService emailService;
//    private final ConfirmationTokenRepository confirmationTokenRepository;
//
//    @Value("${spring.application.mailing.frontend.activation_url}")
//    private String activation_url;
//
//    public void sendVerificationEmail(User user) throws MessagingException {
//        String verificationToken = generateAndSaveVerificationToken(user);
//        //send email
//        emailService.sendEmail(
//                user.getEmail(),
//                user.getFirst_name() + user.getLast_name(),
//                EmailTemplateName.ACTIVATE_ACCOUNT,
//                activation_url,
//                verificationToken,
//                "Account activation"
//        );
//    }
//
//    private String generateAndSaveVerificationToken(User user) {
//
//        String generatedCode = generateVerificationCode(6);
//
//        ConfirmationToken token = ConfirmationToken.builder()
//                .token(generatedCode)
//                .createdAt(LocalDateTime.now())
//                .expiresAt(LocalDateTime.now().plusMinutes(15))
//                .user(user)
//                .build();
//        confirmationTokenRepository.save(token);
//
//        return generatedCode;
//    }
//
//    private String generateVerificationCode(int length) {
//        String characters = "0123456789";
//        StringBuilder codeBuilder = new StringBuilder();
//
//        SecureRandom secureRandom = new SecureRandom();
//
//        for (int i = 0; i < length; i++) {
//            int randomIndex = secureRandom.nextInt(characters.length());
//            codeBuilder.append(characters.charAt(randomIndex));
//        }
//
//        return codeBuilder.toString();
//    }

}
