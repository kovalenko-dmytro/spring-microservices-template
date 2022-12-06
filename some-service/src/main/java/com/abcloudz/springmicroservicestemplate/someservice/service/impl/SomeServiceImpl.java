package com.abcloudz.springmicroservicestemplate.someservice.service.impl;

import com.abcloudz.springmicroservicestemplate.someservice.service.SomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeServiceImpl implements SomeService {

    private final MessageSource messageSource;

}
