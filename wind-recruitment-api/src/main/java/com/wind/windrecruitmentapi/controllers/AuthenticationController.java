package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.ServiceImpl.AuthenticationServiceImpl;
import com.wind.windrecruitmentapi.services.AuthenticationService;
import com.wind.windrecruitmentapi.utils.authentication.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register-manager")
    public ResponseEntity<AuthResponse> registerManager(
            @RequestBody ManagerRegisterRequest request
    ) {
        return ResponseEntity.ok(authService.registerManager(request));
    }
    @PostMapping("/register-candidate")
    public ResponseEntity<AuthResponse> registerCandidate(
            @RequestBody CandidateRegisterRequest request
    ) {
        return ResponseEntity.ok(authService.registerCandidate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login-recruiter")
    public ResponseEntity<AuthResponse> loginRecruiter(
            @RequestBody AuthRequest request
    ) {
        return ResponseEntity.ok(authService.loginRecruiter(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }


}
