package com.abcloudz.springmicroservicestemplate.webuiservice.common.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends WebUIServiceApplicationException {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(HttpStatus status, String message) {
        super(status, message);
    }
}
