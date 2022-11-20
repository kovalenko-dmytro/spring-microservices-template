package com.abcloudz.springmicroservicestemplate.authservice.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AuthServerCreateUserRequestDTO {

    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private List<AuthServerUserCredentialsRequestDTO> credentials;
}
