package com.wind.windrecruitmentapi.controllers;


import com.wind.windrecruitmentapi.services.AuthenticationService;
import com.wind.windrecruitmentapi.utils.authentication.*;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/register-manager")
    public void registerManager(
            @RequestBody ManagerRegisterRequest request
    ) throws MessagingException {
        authService.registerManager(request);
    }
    @PostMapping("/register-candidate")
    public void registerCandidate(
            @RequestBody CandidateRegisterRequest request
    ) throws MessagingException {
        authService.registerCandidate(request);
    }

    @PostMapping("/register-hr-recruiter")
    @PreAuthorize("hasRole('MANAGER')")
    public void registerHRRecruiter(
            @RequestBody ManagerRegisterRequest request
    ) {
        authService.registerHRRecruiter(request);
    }

    @PostMapping("/register-tech-recruiter")
    @PreAuthorize("hasRole('MANAGER')")
    public void registerTechnicalRecruiter(
            @RequestBody ManagerRegisterRequest request
    ) {
        authService.registerTechRecruiter(request);
    }

    @PostMapping("/activate-account")
    public void activateAccount(
        @RequestParam String token
    ) throws MessagingException {
        authService.activateAccount(token);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }


}
