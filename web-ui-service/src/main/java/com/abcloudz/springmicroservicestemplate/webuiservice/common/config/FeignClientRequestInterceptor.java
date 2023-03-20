package com.abcloudz.springmicroservicestemplate.webuiservice.common.config;

import com.abcloudz.springmicroservicestemplate.webuiservice.common.constant.CommonConstant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class FeignClientRequestInterceptor implements RequestInterceptor {

    @Autowired
    private HttpServletRequest request;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            String cookie = cookies[0].getName() + CommonConstant.EQUAL.getValue() + request.getCookies()[0].getValue();
            requestTemplate.header("Cookie", cookie);
        }
    }
}
