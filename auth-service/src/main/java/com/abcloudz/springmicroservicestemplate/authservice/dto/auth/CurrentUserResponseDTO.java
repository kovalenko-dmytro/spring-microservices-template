package com.abcloudz.springmicroservicestemplate.authservice.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrentUserResponseDTO {

    private String username;
}
