package com.abcloudz.springmicroservicestemplate.userservice.filter;

import com.abcloudz.springmicroservicestemplate.userservice.common.CommonConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Base64Utils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoadUserDetailsFilter extends OncePerRequestFilter {

    private final String accessUserDetailsUserName;
    private final String accessUserDetailsPassword;
    private final PasswordEncoder passwordEncoder;

    public LoadUserDetailsFilter(String accessUserDetailsUserName,
                                 String accessUserDetailsPassword,
                                 PasswordEncoder passwordEncoder) {

        this.accessUserDetailsUserName = accessUserDetailsUserName;
        this.accessUserDetailsPassword = accessUserDetailsPassword;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {

        String authHeader = request.getHeader(CommonConstant.AUTH_HEADER.getValue());
        if (Objects.isNull(authHeader)) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        authHeader = authHeader.replace(CommonConstant.BASIC_AUTH_HEADER_PREFIX.getValue(), StringUtils.EMPTY);
        byte[] bytes = Base64Utils.decodeFromString(authHeader);
        String[] params = new String(bytes).split(CommonConstant.COLON.getValue());
        if (!passwordEncoder.matches(accessUserDetailsUserName, params[0])
            || !passwordEncoder.matches(accessUserDetailsPassword, params[1])) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        /*if (!accessLoadUserUserName.contentEquals(params[0]) || !accessLoadUserPassword.contentEquals(params[1])) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }*/
        filterChain.doFilter(request, response);
    }
}
