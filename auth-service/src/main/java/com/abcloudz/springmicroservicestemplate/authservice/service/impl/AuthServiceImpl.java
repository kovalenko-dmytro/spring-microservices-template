package com.abcloudz.springmicroservicestemplate.authservice.service.impl;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;
import com.abcloudz.springmicroservicestemplate.authservice.restclient.UserServiceClient;
import com.abcloudz.springmicroservicestemplate.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceClient userServiceClient;
    private final MessageSource messageSource;

    @Override
    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        return null;
    }

    @Override
    public void signUp(SignUpRequestDTO signUpRequestDTO, Locale locale) {

    }

    @Override
    public SignInResponseDTO refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return null;
    }

    @Override
    public CurrentUserResponseDTO getCurrentUser(HttpServletRequest request) {
        return null;
    }

    @Override
    public void logout(HttpServletRequest request) {

    }
}
