package com.abcloudz.springmicroservicestemplate.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class SessionFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession httpSession = context.getRequest().getSession(false);
        if (Objects.nonNull(httpSession)) {
            context.addZuulRequestHeader("Cookie", "SESSION=" + httpSession.getId());
        }
        return null;
    }
}
