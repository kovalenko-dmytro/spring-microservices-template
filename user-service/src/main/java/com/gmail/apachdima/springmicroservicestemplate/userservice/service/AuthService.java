package com.gmail.apachdima.springmicroservicestemplate.userservice.service;

import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.auth.SignInRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface AuthService {

    void signIn(SignInRequestDTO signInRequestDTO);
    void signUp(SignUpRequestDTO signUpRequestDTO);
    UserResponseDTO getCurrentUser(Locale locale);
    void logout(HttpServletRequest request);
}
