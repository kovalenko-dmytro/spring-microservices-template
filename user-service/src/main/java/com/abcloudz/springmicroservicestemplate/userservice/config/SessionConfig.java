package com.abcloudz.springmicroservicestemplate.userservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.FlushMode;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisHttpSession(flushMode = FlushMode.IMMEDIATE)
@RequiredArgsConstructor
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {
}
