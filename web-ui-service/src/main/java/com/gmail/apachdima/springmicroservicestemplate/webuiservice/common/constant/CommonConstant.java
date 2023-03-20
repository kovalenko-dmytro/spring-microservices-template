package com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommonConstant {

    MESSAGE_SOURCE_PATH("classpath:messages/messages"),
    COLON(":"),
    DOT("."),
    EQUAL("="),
    COMMA(",");

    private final String value;
}
