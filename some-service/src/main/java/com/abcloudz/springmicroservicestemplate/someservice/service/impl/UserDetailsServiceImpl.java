package com.abcloudz.springmicroservicestemplate.someservice.service.impl;

import com.abcloudz.springmicroservicestemplate.someservice.client.UserServiceClient;
import com.abcloudz.springmicroservicestemplate.someservice.common.CommonConstant;
import com.abcloudz.springmicroservicestemplate.someservice.common.Entity;
import com.abcloudz.springmicroservicestemplate.someservice.common.message.Error;
import com.abcloudz.springmicroservicestemplate.someservice.dto.user.UserDetailsResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.Locale;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserServiceClient userServiceClient;
    private final MessageSource messageSource;
    private final PasswordEncoder passwordEncoder;

    @Value("${access.load.user.username}")
    private String accessUserDetailsUserName;
    @Value("${access.load.user.password}")
    private String accessUserDetailsPassword;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<UserDetailsResponseDTO> response = userServiceClient.getByUserName(username, getAuthHeader());
        UserDetailsResponseDTO body = response.getBody();
        if (response.getStatusCode().isError() || Objects.isNull(body)) {
            Object[] params = new Object[]{Entity.USER.getName(), Entity.UserField.USER_NAME.getFieldName(), username};
            throw new UsernameNotFoundException(messageSource.getMessage(Error.ENTITY_NOT_FOUND.getKey(), params, Locale.ENGLISH));
        }
        return body;
    }

    private String getAuthHeader() {
        byte[] bytes = Base64Utils
            .encode((passwordEncoder.encode(accessUserDetailsUserName) +
                CommonConstant.COLON.getValue() +
                passwordEncoder.encode(accessUserDetailsPassword)).getBytes());
        return CommonConstant.BASIC_AUTH_HEADER_PREFIX.getValue().concat(new String(bytes));
    }
}
