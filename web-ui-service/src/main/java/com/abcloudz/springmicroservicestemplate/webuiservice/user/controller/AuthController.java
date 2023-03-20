package com.abcloudz.springmicroservicestemplate.webuiservice.user.controller;

import com.abcloudz.springmicroservicestemplate.webuiservice.user.dto.auth.SignInRequestDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.user.dto.auth.SignInResponseDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.user.dto.auth.SignUpRequestDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("request", new SignInRequestDTO());
        return modelAndView;
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages/dashboard");
        return modelAndView;
    }

    @PostMapping(value = "/sign-in")
    public ModelAndView signIn(@Valid SignInRequestDTO request, BindingResult bindingResult, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("index");
            modelAndView.addObject("request", request);
            return modelAndView;
        }
        SignInResponseDTO signInResponse = authService.signIn(request);
        modelAndView.setViewName(signInResponse.getStatus().is2xxSuccessful() ? "redirect:/dashboard" : "redirect:/index");
        modelAndView.addObject("error", signInResponse.getError());
        response.setHeader("set-cookie", signInResponse.getCookieHeader());
        return modelAndView;
    }

    @GetMapping(value = "/sign-out")
    public ModelAndView signOut() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/sign-up")
    public ModelAndView signUp() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("request", new SignUpRequestDTO());
        modelAndView.setViewName("/pages/sign-up");
        return modelAndView;
    }

    @PostMapping(value = "/sign-up")
    public ModelAndView registration(@Valid SignUpRequestDTO request, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/pages/sign-up");
        } else {
            //authService.save(user);
            modelAndView.setViewName("redirect:/index");
        }
        return modelAndView;
    }
}
