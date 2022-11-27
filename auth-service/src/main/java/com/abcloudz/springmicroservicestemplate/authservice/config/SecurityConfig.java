package com.abcloudz.springmicroservicestemplate.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .anyRequest()
            .permitAll();

        return http.build();
        /*http.csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/api/v1/auth/sign-in", "/api/v1/auth/sign-up")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login()
            .and()
            .oauth2ResourceServer()
            .jwt()
            .and()
            .and()
            .logout()
            .logoutUrl("/api/v1/auth/logout");

        return http.build();*/
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
            web.ignoring()
            .antMatchers("/api/v1/auth/sign-in",
                "/api/v1/auth/sign-up",
                "/api-docs",
                "/api-docs/**",
                "/v3/api-docs/**",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/webjars/**",
                "/swagger-ui/**");
    }
}
