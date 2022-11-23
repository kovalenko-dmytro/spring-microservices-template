package com.abcloudz.springmicroservicestemplate.gatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeExchange()
            .pathMatchers("/api/v1/auth/sign-in",
                "/api/v1/auth/sign-up")
            .permitAll()
            .anyExchange()
            .authenticated()
            /*.and()
            .oauth2Login()*/
            .and()
            .oauth2ResourceServer()
            .jwt()
            .and()
            .and()
            .logout()
            .logoutUrl("/api/v1/auth/logout");

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
            web.ignoring()
                .antMatchers("/api/v1/auth/sign-in",
                    "/api/v1/auth/sign-up");
    }
}
