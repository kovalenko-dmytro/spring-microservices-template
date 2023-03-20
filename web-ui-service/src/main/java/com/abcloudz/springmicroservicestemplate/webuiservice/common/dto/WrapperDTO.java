package com.abcloudz.springmicroservicestemplate.webuiservice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WrapperDTO<T> {

    private HttpStatus status;
    T data;
    private String message;
}
