package com.abcloudz.springmicroservicestemplate.authservice.service.impl;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;
import com.abcloudz.springmicroservicestemplate.authservice.restclient.AuthServerClient;
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

    private final AuthServerClient authServerClient;
    private final UserServiceClient userServiceClient;
    private final MessageSource messageSource;

    @Override
    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        AuthServerAccessDetailResponseDTO details = authServerClient.getUserAccessDetails(signInRequestDTO);
        return SignInResponseDTO.builder()
            .accessToken(details.getAccessToken())
            .refreshToken(details.getRefreshToken())
            .build();
    }

    @Override
    public void signUp(SignUpRequestDTO signUpRequestDTO, Locale locale) {
        AuthServerAccessDetailResponseDTO details = authServerClient.getAdminAccessDetails();
        authServerClient.createUser(details.getAccessToken(), signUpRequestDTO, locale);
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
