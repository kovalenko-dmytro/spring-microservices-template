package com.abcloudz.springmicroservicestemplate.webuiservice.common.exception;

import com.abcloudz.springmicroservicestemplate.webuiservice.common.constant.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FeignClientExceptionWrapper {

    private String timestamp;
    private String status;
    private String error;
    private String[] errors;
    private String message;
    private String path;

    public String convert() {
        return this.getErrors() == null
            ? null
            : Arrays.stream(this.getErrors())
                .sequential()
                .collect(Collectors.joining(CommonConstant.COMMA.getValue()));
    }
}
