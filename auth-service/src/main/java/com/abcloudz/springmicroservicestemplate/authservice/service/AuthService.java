package com.abcloudz.springmicroservicestemplate.authservice.service;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);
    void signUp(SignUpRequestDTO signUpRequestDTO);
    SignInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO);
    CurrentUserResponseDTO getCurrentUser(HttpServletRequest request);
    void logout(HttpServletRequest request);
}
