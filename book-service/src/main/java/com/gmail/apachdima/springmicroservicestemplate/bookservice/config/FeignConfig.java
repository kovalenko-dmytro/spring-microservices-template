package com.gmail.apachdima.springmicroservicestemplate.bookservice.config;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Client feignClient() {
        return new Client.Default(null, null);
    }
}
