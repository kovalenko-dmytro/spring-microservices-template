package com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Info {

    INFO_LOG_CONTROLLER_EXECUTE("info.log.controller.execute");

    private final String key;
}
