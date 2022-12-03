package com.abcloudz.springmicroservicestemplate.userservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class CookieSerializationConfig {

    @Value("${server.servlet.session.cookie.name}")
    private String name;
    @Value("${server.servlet.session.cookie.http-only}")
    private boolean httpOnly;
    @Value("${server.servlet.session.cookie.domain}")
    private String domain;
    @Value("${server.servlet.session.cookie.secure}")
    private boolean secure;
    @Value("${server.servlet.session.cookie.path}")
    private String path;

    @Bean
    CookieSerializer cookieSerializer() {
        DefaultCookieSerializer defaultCookieSerializer = new DefaultCookieSerializer();
        defaultCookieSerializer.setCookieName(name);
        defaultCookieSerializer.setUseHttpOnlyCookie(httpOnly);
        defaultCookieSerializer.setDomainName(domain);
        defaultCookieSerializer.setUseSecureCookie(secure);
        defaultCookieSerializer.setCookiePath(path);
        defaultCookieSerializer.setSameSite("Lax");
        return defaultCookieSerializer;
    }
}
