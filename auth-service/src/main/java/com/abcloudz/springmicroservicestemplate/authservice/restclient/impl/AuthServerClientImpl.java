package com.abcloudz.springmicroservicestemplate.authservice.restclient.impl;

import com.abcloudz.springmicroservicestemplate.authservice.restclient.AuthServerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServerClientImpl implements AuthServerClient {

    private final MessageSource messageSource;
}
