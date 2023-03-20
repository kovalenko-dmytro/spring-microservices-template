package com.abcloudz.springmicroservicestemplate.webuiservice.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends WebUIServiceApplicationException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
