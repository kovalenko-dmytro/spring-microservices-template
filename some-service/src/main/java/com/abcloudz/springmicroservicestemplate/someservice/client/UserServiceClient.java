package com.abcloudz.springmicroservicestemplate.someservice.client;

import com.abcloudz.springmicroservicestemplate.someservice.dto.user.UserDetailsResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.ws.rs.QueryParam;

@FeignClient(value = "user-service", url = "http://localhost:8084/template/api/v1/users")
public interface UserServiceClient {

    @GetMapping(value = "/user-details")
    ResponseEntity<UserDetailsResponseDTO> getByUserName(@QueryParam("userName") String userName,
                                                         @RequestHeader("Authorization") String header);
}
