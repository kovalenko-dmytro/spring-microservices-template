package com.abcloudz.springmicroservicestemplate.userservice.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OpenApi {

    OPEN_API_INFO_TITLE("User Service REST API documentation"),
    OPEN_API_SECURITY_SCHEMA_NAME("bearerAuth"),
    OPEN_API_SECURITY_SCHEMA("bearer"),
    OPEN_API_SECURITY_SCHEMA_BEARER_FORMAT("JWT");

    private final String value;
}
