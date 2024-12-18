package com.wind.windrecruitmentapi.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wind.windrecruitmentapi.entities.*;
import com.wind.windrecruitmentapi.repositories.UserRepository;
import com.wind.windrecruitmentapi.securityConfig.JWTService;
import com.wind.windrecruitmentapi.services.AuthenticationService;
import com.wind.windrecruitmentapi.utils.authentication.*;
import com.wind.windrecruitmentapi.utils.authorization.UserRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {


    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

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
//        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthResponse.builder()
                .access_token(jwtToken)
//                .refresh_token(refreshToken)
//                .user_role(user.getRole().name().toLowerCase())
                .build();
    }


//    @Override
//    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//        final String refreshToken;
//        final String userEmail;
//        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
//            throw new IllegalStateException("Bad request");
//        }
//        refreshToken = authHeader.substring(7);
//        userEmail = jwtService.extractUsername(refreshToken);
//        if (userEmail != null) {
//            User user = this.repository.findByEmail(userEmail)
//                    .orElseThrow();
//            if (jwtService.isTokenValid(refreshToken, user)) {
//                String accessToken = jwtService.generateToken(user);
//
//
//                AuthResponse authResponse = AuthResponse.builder()
//                        .access_token(accessToken)
//                        .refresh_token(refreshToken)
//                        .build();
//                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
//            }
//        }
//    }

    @Override
    public void register(RegisterRequest request) {

        User user = User.builder()
                .ownerName(request.getOwnerName())
                .businessName(request.getBusinessName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(UserRole.BUSINESS)
                .build();
        repository.save(user);
    }


}
