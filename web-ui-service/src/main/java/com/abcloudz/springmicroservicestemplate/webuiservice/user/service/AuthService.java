package com.abcloudz.springmicroservicestemplate.webuiservice.user.service;

import com.abcloudz.springmicroservicestemplate.webuiservice.user.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.user.dto.auth.SignInResponseDTO;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO request);
}
