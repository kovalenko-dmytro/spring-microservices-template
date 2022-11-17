package com.abcloudz.springmicroservicestemplate.authservice.exception;

public class AuthServiceApplicationException extends RuntimeException {

    public AuthServiceApplicationException() {
        super();
    }

    public AuthServiceApplicationException(String message) {
        super(message);
    }
}
