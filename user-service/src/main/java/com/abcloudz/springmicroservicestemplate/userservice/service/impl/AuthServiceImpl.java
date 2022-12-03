package com.abcloudz.springmicroservicestemplate.userservice.service.impl;

import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;
import com.abcloudz.springmicroservicestemplate.userservice.model.User;
import com.abcloudz.springmicroservicestemplate.userservice.service.AuthService;
import com.abcloudz.springmicroservicestemplate.userservice.service.UserService;
import com.abcloudz.springmicroservicestemplate.userservice.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public void signIn(SignInRequestDTO request) {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public void signUp(SignUpRequestDTO signUpRequestDTO) {
        userService.create(userMapper.toUserRequestDTO(signUpRequestDTO));
    }

    @Override
    public UserResponseDTO getCurrentUser(Locale locale) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.getUserByUserName(authentication.getName(), locale);
        return userMapper.toUserResponseDTO(currentUser);
    }
}
