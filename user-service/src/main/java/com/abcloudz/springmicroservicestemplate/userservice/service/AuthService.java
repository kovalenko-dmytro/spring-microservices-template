package com.abcloudz.springmicroservicestemplate.userservice.service;

import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;

import java.util.Locale;

public interface AuthService {

    void signIn(SignInRequestDTO signInRequestDTO);
    void signUp(SignUpRequestDTO signUpRequestDTO);
    UserResponseDTO getCurrentUser(Locale locale);
}
