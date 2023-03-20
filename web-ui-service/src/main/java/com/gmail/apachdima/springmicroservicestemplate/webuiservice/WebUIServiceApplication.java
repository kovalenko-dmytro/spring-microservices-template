package com.gmail.apachdima.springmicroservicestemplate.webuiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class WebUIServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebUIServiceApplication.class, args);
	}

}
