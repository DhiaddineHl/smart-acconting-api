package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.authentication.*;
import org.springframework.stereotype.Service;

@Service("authService")
public interface AuthenticationService {
    AuthResponse registerCandidate(CandidateRegisterRequest request);

    AuthResponse registerManager(ManagerRegisterRequest request);

    AuthResponse registerHRRecruiter(ManagerRegisterRequest request);

    AuthResponse registerTechRecruiter(ManagerRegisterRequest request);

    AuthResponse authenticate(AuthRequest request);

    AuthResponse register(RegisterRequest request);
}
