package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.authentication.*;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("authService")
public interface AuthenticationService {
    void registerCandidate(CandidateRegisterRequest request) throws MessagingException;

    void registerManager(ManagerRegisterRequest request) throws MessagingException;

    void registerHRRecruiter(ManagerRegisterRequest request);

    void registerTechRecruiter(ManagerRegisterRequest request);

    AuthResponse authenticate(AuthRequest request);

    void activateAccount(String token) throws MessagingException;

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
