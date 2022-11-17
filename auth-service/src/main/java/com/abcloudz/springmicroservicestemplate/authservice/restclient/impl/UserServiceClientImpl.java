package com.abcloudz.springmicroservicestemplate.authservice.restclient.impl;

import com.abcloudz.springmicroservicestemplate.authservice.restclient.UserServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceClientImpl implements UserServiceClient {

    private final MessageSource messageSource;
}
