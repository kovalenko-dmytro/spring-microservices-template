package com.abcloudz.springmicroservicestemplate.authservice.controller;

import com.abcloudz.springmicroservicestemplate.authservice.dto.auth.*;
import com.abcloudz.springmicroservicestemplate.authservice.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@Tag(name = "Auth Service REST API")
@RestController
@RequestMapping(value = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SignInResponseDTO> signIn(@Valid @RequestBody SignInRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.signIn(requestDTO));
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpRequestDTO requestDTO,
                                       @RequestParam(value = "locale", required = false, defaultValue = "en") Locale locale) {
        authService.signUp(requestDTO, locale);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/refresh-token")
    public ResponseEntity<SignInResponseDTO> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(authService.refreshToken(requestDTO));
    }

    @GetMapping(value = "/current-user")
    public ResponseEntity<CurrentUserResponseDTO> getCurrentUser(HttpServletRequest request) {
        return ResponseEntity.ok().body(authService.getCurrentUser(request));
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        authService.logout(request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
