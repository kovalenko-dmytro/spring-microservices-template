package com.gmail.apachdima.springmicroservicestemplate.userservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserResponseDTO {

    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private boolean enabled;
    private LocalDateTime created;
    private Set<String> roles;
}
