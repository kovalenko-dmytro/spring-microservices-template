package com.abcloudz.springmicroservicestemplate.userservice.service;

import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public interface AuthService {

    void signIn(SignInRequestDTO signInRequestDTO);
    void signUp(SignUpRequestDTO signUpRequestDTO);
    UserResponseDTO getCurrentUser(Locale locale);
    User getUserDetails(String userName, Locale locale);
    void logout(HttpServletRequest request);
}
