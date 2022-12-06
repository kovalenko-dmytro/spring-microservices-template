package com.abcloudz.springmicroservicestemplate.someservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.ws.rs.QueryParam;

@FeignClient(value = "user-service", url = "http://localhost:8084/template")
public interface UserServiceClient {

    @GetMapping(value = "/api/v1/auth/user-details")
    ResponseEntity<User> getUserDetails(@QueryParam("userName") String userName, @RequestHeader("Authorization") String header);
}
