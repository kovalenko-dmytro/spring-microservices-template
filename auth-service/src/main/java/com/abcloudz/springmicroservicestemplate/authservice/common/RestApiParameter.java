package com.abcloudz.springmicroservicestemplate.authservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RestApiParameter {

    BEARER_PREFIX("Bearer "),
    USERNAME("username"),
    PASSWORD("password"),
    GRANT_TYPE("grant_type"),
    CLIENT_ID("client_id"),
    CLIENT_SECRET("client_secret");

    private final String name;
}
