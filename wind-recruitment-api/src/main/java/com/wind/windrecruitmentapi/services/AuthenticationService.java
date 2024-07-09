package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.authentication.*;
import org.springframework.stereotype.Service;

@Service("authService")
public interface AuthenticationService {
    AuthResponse registerCandidate(CandidateRegisterRequest request);

    AuthResponse registerManager(ManagerRegisterRequest request);

    AuthResponse loginRecruiter(AuthRequest request);

    AuthResponse authenticate(AuthRequest request);

    AuthResponse register(RegisterRequest request);
}
