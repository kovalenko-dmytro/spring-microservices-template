package com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.handler;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.exception.AuthenticationException;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.exception.ForbiddenException;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.exception.NotFoundException;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.exception.WebUIServiceApplicationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class ServiceErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AuthenticationException.class, ForbiddenException.class})
    public ModelAndView handleAuthException(WebUIServiceApplicationException ex) {
        ModelAndView view = new ModelAndView("pages/access-denied");
        view.addObject("exception", ex.getMessage());
        return view;
    }

    @ExceptionHandler({NotFoundException.class})
    public ModelAndView handleNotFoundException(WebUIServiceApplicationException ex) {
        ModelAndView view = new ModelAndView("pages/not-found");
        view.addObject("error", ex.getMessage());
        return view;
    }

    @ExceptionHandler({RuntimeException.class})
    public void handleCommonException(RuntimeException ex,
                                              HttpServletRequest request,
                                              HttpServletResponse response) throws IOException {
        request.setAttribute("error", ex.getMessage());
        response.sendRedirect(request.getContextPath() + request.getRequestURI());
    }
}
