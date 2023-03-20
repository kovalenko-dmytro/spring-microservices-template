package com.abcloudz.springmicroservicestemplate.webuiservice.common.config;

import com.abcloudz.springmicroservicestemplate.webuiservice.common.exception.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        FeignException feignException = FeignException.errorStatus(methodKey, response);

        return switch (response.status()) {
            case 401 -> new AuthenticationException(feignException.contentUTF8());
            case 403 -> new ForbiddenException(feignException.contentUTF8());
            case 404 -> new NotFoundException(feignException.contentUTF8());
            default -> new WebUIServiceApplicationException(HttpStatus.resolve(feignException.status()), feignException.contentUTF8());
        };
    }
}
