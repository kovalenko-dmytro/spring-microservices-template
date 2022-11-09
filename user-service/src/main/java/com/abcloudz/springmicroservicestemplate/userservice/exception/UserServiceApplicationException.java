package com.abcloudz.springmicroservicestemplate.userservice.exception;

public class UserServiceApplicationException extends RuntimeException {

    public UserServiceApplicationException() {
        super();
    }

    public UserServiceApplicationException(String message) {
        super(message);
    }
}
