package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service.impl;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.client.UserServiceClient;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserServiceClient client;
}
