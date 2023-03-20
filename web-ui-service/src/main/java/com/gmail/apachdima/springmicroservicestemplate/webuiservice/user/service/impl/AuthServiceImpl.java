package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service.impl;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.client.UserServiceClient;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth.SignInRequestDTO;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth.SignInResponseDTO;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserServiceClient client;

    @Override
    public SignInResponseDTO signIn(SignInRequestDTO request) {
        ResponseEntity<?> response = client.signIn(request);
        String cookieHeader = null;
        HttpStatus status = null;
        if (response != null) {
            status = response.getStatusCode();
            List<String> cookieHeaders = response.getHeaders().get("set-cookie");
            if (cookieHeaders != null) {
                cookieHeader = cookieHeaders.get(0);
            }
        }
        return SignInResponseDTO.builder()
            .status(status != null ? status : HttpStatus.UNAUTHORIZED)
            .cookieHeader(cookieHeader)
            .error(response.getStatusCode().isError() ? response.getBody().toString() : null)
            .build();
    }
}
