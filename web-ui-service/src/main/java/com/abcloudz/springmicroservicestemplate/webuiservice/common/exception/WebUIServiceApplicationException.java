package com.abcloudz.springmicroservicestemplate.webuiservice.common.exception;

import org.springframework.http.HttpStatus;

public class WebUIServiceApplicationException extends RuntimeException {

    private HttpStatus status;

    public WebUIServiceApplicationException() {
        super();
    }

    public WebUIServiceApplicationException(String message) {
        super(message);
    }

    public WebUIServiceApplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
}
