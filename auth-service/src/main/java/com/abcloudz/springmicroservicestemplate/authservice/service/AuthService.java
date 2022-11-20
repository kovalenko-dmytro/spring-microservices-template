package com.abcloudz.springmicroservicestemplate.authservice.service;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);
    void signUp(SignUpRequestDTO signUpRequestDTO, Locale locale);
    SignInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO);
    CurrentUserResponseDTO getCurrentUser(HttpServletRequest request);
    void logout(HttpServletRequest request);
}
