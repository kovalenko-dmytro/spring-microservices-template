package com.abcloudz.springmicroservicestemplate.authservice.restclient.impl;

import com.abcloudz.springmicroservicestemplate.authservice.common.RestApiParameter;
import com.abcloudz.springmicroservicestemplate.authservice.common.message.Error;
import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;
import com.abcloudz.springmicroservicestemplate.authservice.exception.AuthServiceApplicationException;
import com.abcloudz.springmicroservicestemplate.authservice.restclient.AuthServerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AuthServerClientImpl implements AuthServerClient {

    private static final String GRANT_TYPE_VALUE = "password";
    private static final String ADMIN_CLIENT_ID_VALUE = "admin-cli";

    private final WebClient authServerWebClient;
    private final MessageSource messageSource;

    @Value("${keycloak-server.admin.username}")
    private String authServerAdminUserName;
    @Value("${keycloak-server.admin.password}")
    private String authServerAdminPassword;
    @Value("${keycloak-server.realm}")
    private String applicationRealm;
    @Value("${keycloak-server.gateway-client-id}")
    private String gatewayClientId;
    @Value("${keycloak-server.gateway-client-secret}")
    private String gatewayClientSecret;

    @Override
    public AuthServerAccessDetailResponseDTO getAdminAccessDetails() {
        return authServerWebClient
            .post()
            .uri("/realms/master/protocol/openid-connect/token")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .body(BodyInserters
                .fromFormData(RestApiParameter.USERNAME.getName(), authServerAdminUserName)
                .with(RestApiParameter.PASSWORD.getName(), authServerAdminPassword)
                .with(RestApiParameter.GRANT_TYPE.getName(), GRANT_TYPE_VALUE)
                .with(RestApiParameter.CLIENT_ID.getName(), ADMIN_CLIENT_ID_VALUE))
            .retrieve()
            .bodyToMono(AuthServerAccessDetailResponseDTO.class)
            .block();
    }

    @Override
    public void createUser(String accessToken, SignUpRequestDTO requestDTO, Locale locale) {
        AuthServerCreateUserRequestDTO request = buildCreateUserRequest(requestDTO);
        authServerWebClient
            .post()
            .uri("/admin/realms/".concat(applicationRealm).concat("/users"))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .header(HttpHeaders.AUTHORIZATION, RestApiParameter.BEARER_PREFIX.getName().concat(accessToken))
            .body(BodyInserters.fromValue(request))
            .retrieve()
            .bodyToMono(Void.class)
            .onErrorMap(throwable ->
                new AuthServiceApplicationException(
                    messageSource.getMessage(
                        Error.SIGNUP_FAILED.getKey(),
                        new Object[]{requestDTO.getUsername(), throwable.getMessage()}, locale)))
            .block();
    }

    @Override
    public AuthServerAccessDetailResponseDTO getUserAccessDetails(SignInRequestDTO signInRequestDTO) {
        return authServerWebClient
            .post()
            .uri("/realms/".concat(applicationRealm).concat("/protocol/openid-connect/token"))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .body(BodyInserters
                .fromFormData(RestApiParameter.CLIENT_ID.getName(), gatewayClientId)
                .with(RestApiParameter.CLIENT_SECRET.getName(), gatewayClientSecret)
                .with(RestApiParameter.USERNAME.getName(), signInRequestDTO.getUsername())
                .with(RestApiParameter.PASSWORD.getName(), signInRequestDTO.getPassword())
                .with(RestApiParameter.GRANT_TYPE.getName(), GRANT_TYPE_VALUE))
            .retrieve()
            .bodyToMono(AuthServerAccessDetailResponseDTO.class)
            .block();
    }

    private AuthServerCreateUserRequestDTO buildCreateUserRequest(SignUpRequestDTO requestDTO) {
        return AuthServerCreateUserRequestDTO.builder()
            .username(requestDTO.getUsername())
            .firstName(requestDTO.getFirstName())
            .lastName(requestDTO.getLastName())
            .enabled(true)
            .credentials(List.of(AuthServerUserCredentialsRequestDTO.builder()
                .type(GRANT_TYPE_VALUE)
                .value(requestDTO.getPassword())
                .temporary(false)
                .build()))
            .build();
    }
}
