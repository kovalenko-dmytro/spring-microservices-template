package com.abcloudz.springmicroservicestemplate.userservice.config;

import com.abcloudz.springmicroservicestemplate.userservice.filter.LoadUserDetailsFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsServiceImpl;
    private final PasswordEncoder passwordEncoder;

    @Value("${access.load.user.username}")
    private String accessUserDetailsUserName;
    @Value("${access.load.user.password}")
    private String accessUserDetailsPassword;

    @Bean
    public LogoutHandler logoutHandler() {
        return new SecurityContextLogoutHandler();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public FilterRegistrationBean<LoadUserDetailsFilter> loadUserDetailsFilter() {
        FilterRegistrationBean<LoadUserDetailsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(
            new LoadUserDetailsFilter(accessUserDetailsUserName, accessUserDetailsPassword, passwordEncoder));
        registrationBean.addUrlPatterns("/api/v1/users/user-details");
        return registrationBean;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            .sessionFixation(SessionManagementConfigurer.SessionFixationConfigurer::newSession)
            .maximumSessions(1)
            .expiredSessionStrategy(event -> event.getResponse().sendError(HttpStatus.UNAUTHORIZED.value()))
            .maxSessionsPreventsLogin(false)
            .and().and()
            .authorizeRequests()
            .antMatchers("/api/v1/users/user-details").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
            .and()
            .formLogin().disable()
            .httpBasic().disable()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/api/v1/auth/logout"))
            .invalidateHttpSession(true)
            .clearAuthentication(true);

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
            web.ignoring()
                .antMatchers("/api/v1/auth/sign-in",
                    "/api/v1/auth/sign-up",
                    "/api/v1/users/user-details",
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
