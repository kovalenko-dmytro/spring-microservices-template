package com.abcloudz.springmicroservicestemplate.authservice.restclient;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.AuthServerAccessDetailResponseDTO;
import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.SignUpRequestDTO;

import java.util.Locale;

public interface AuthServerClient {

    AuthServerAccessDetailResponseDTO getAdminAccessDetails();
    void createUser(String accessToken, SignUpRequestDTO requestDTO, Locale locale);
    AuthServerAccessDetailResponseDTO getUserAccessDetails(SignInRequestDTO signInRequestDTO);
}
