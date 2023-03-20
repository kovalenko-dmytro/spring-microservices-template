package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth.SignInRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth.SignInResponseDTO;

public interface AuthService {

    SignInResponseDTO signIn(SignInRequestDTO request);
}
