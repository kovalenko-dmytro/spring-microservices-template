package com.abcloudz.springmicroservicestemplate.userservice.controller;

import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.userservice.dto.user.UserResponseDTO;
import com.abcloudz.springmicroservicestemplate.userservice.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Objects;

@Tag(name = "User Service Authentication REST API")
@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LogoutHandler logoutHandler;

    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInRequestDTO requestDTO) {
        authService.signIn(requestDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequestDTO requestDTO) {
        authService.signUp(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/current-user")
    public ResponseEntity<UserResponseDTO> getCurrentUser(@RequestParam(value = "locale", required = false, defaultValue = "en") Locale locale) {
        return ResponseEntity.ok().body(authService.getCurrentUser(locale));
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.nonNull(auth)){
            logoutHandler.logout(request, response, auth);
        }
        return ResponseEntity.ok().build();
    }
}
