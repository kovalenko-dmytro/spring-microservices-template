package com.gmail.apachdima.springmicroservicestemplate.bookservice.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Info {

    INFO_LOG_CONTROLLER_EXECUTE("info.log.controller.execute");

    private final String key;
}
