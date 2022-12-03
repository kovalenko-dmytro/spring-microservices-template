package com.abcloudz.springmicroservicestemplate.gatewayservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class SessionFilter extends ZuulFilter {

    private final SessionRepository sessionRepository;

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
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession httpSession = context.getRequest().getSession(false);
        if (Objects.nonNull(httpSession)) {
            Session session = sessionRepository.findById(httpSession.getId());
            if (Objects.nonNull(session)) {
                context.addZuulRequestHeader("Cookie", "SESSION=" + session.getId());
                log.info("SessionFilter session proxy: {}", session.getId());
            }
        }
        return null;
    }
}
