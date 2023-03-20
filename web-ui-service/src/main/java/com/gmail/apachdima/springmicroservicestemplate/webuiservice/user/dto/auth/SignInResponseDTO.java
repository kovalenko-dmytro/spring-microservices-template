package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class SignInResponseDTO {

    private HttpStatus status;
    private String cookieHeader;
    private String error;
}
