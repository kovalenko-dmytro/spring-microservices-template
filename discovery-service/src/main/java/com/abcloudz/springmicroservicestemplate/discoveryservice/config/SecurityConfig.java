package com.abcloudz.springmicroservicestemplate.discoveryservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig {

    @Value("${spring.security.user.name}")
    private String userName;
    @Value("${spring.security.user.password}")
    private String password;
    @Value("${spring.security.user.roles}")
    private String roles;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User
            .withUsername(userName)
            .password(passwordEncoder().encode(password))
            .roles(roles)
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
            csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/eureka/**").authenticated()
            .antMatchers(HttpMethod.POST, "/eureka/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/eureka/**").authenticated()
            .anyRequest().authenticated().and().httpBasic();
        return http.build();
    }
}
