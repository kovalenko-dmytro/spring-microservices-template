package com.abcloudz.springmicroservicestemplate.userservice.util.mapper;

import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserDetailsResponseDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;
import com.abcloudz.springmicroservicestemplate.userservice.model.Role;
import com.abcloudz.springmicroservicestemplate.userservice.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Objects;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    UserResponseDTO toUserResponseDTO(User user);

    @Mapping(source = "userName", target = "username")
    @Mapping(source = "enabled", target = "isEnabled")
    @Mapping(source = "roles", target = "authorities")
    UserDetailsResponseDTO toUserDetailsResponseDTO(User user);

    UserRequestDTO toUserRequestDTO(SignUpRequestDTO signUpRequestDTO);

    default String roleToString(Role role) {
        return (Objects.isNull(role)) ? null : role.getRole().name();
    }

    default GrantedAuthority roleToAuthority(Role role) {
        return (Objects.isNull(role)) ? null : new SimpleGrantedAuthority("ROLE_".concat(role.getRole().name()));
    }
}
