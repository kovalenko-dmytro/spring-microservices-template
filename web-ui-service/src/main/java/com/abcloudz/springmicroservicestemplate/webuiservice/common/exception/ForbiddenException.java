package com.abcloudz.springmicroservicestemplate.webuiservice.common.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends WebUIServiceApplicationException {

    public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(HttpStatus status, String message) {
        super(status, message);
    }
}
