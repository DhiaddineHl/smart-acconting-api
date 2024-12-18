package com.wind.windrecruitmentapi.services;

import com.wind.windrecruitmentapi.utils.authentication.*;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("authService")
public interface AuthenticationService {

    AuthResponse authenticate(AuthRequest request);


//    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;


    void register(RegisterRequest request);
}
