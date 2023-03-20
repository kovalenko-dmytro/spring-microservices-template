package com.gmail.apachdima.springmicroservicestemplate.userservice.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignInRequestDTO {

    @NotBlank
    @Size(min = 2, max = 50)
    private String userName;
    @Size(min = 2, max = 50)
    private String password;
}
