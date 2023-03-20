package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.client;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth.SignInRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "${client.user-service.base-uri}")
public interface UserServiceClient {

    @PostMapping(value = "/api/v1/auth/sign-in")
    ResponseEntity<?> signIn(SignInRequestDTO requestDTO);
}
