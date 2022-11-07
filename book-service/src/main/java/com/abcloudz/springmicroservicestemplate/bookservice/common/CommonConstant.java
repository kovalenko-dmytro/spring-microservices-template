package com.abcloudz.springmicroservicestemplate.bookservice.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonConstant {

    MESSAGE_SOURCE_PATH("classpath:messages/messages"),
    COLON(":");

    private final String value;
}
