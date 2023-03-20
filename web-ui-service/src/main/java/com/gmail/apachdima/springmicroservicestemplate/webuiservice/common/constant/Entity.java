package com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Entity {

    USER("User"),
    BOOK("Book");

    private final String name;

    @AllArgsConstructor
    @Getter
    public enum Field {

        ID("id");

        private final String fieldName;
    }
}
