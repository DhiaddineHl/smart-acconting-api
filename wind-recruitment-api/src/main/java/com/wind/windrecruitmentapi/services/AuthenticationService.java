package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.authentication.*;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service("authService")
public interface AuthenticationService {
    void registerCandidate(CandidateRegisterRequest request) throws MessagingException;

    void registerManager(ManagerRegisterRequest request) throws MessagingException;

    void registerHRRecruiter(ManagerRegisterRequest request);

    void registerTechRecruiter(ManagerRegisterRequest request);

    AuthResponse authenticate(AuthRequest request);

}
