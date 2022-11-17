package com.abcloudz.springmicroservicestemplate.authservice.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RefreshTokenRequestDTO {

    @NotBlank
    private String refreshToken;
}
