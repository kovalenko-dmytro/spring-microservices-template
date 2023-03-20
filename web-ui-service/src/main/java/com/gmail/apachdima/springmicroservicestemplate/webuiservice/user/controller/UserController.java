package com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.controller;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/dashboard/users")
    public ModelAndView books(@RequestParam("page") Integer page,
                              @RequestParam("size") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        //WrapperDTO<Page<BookResponseDTO>> booksResponse = bookService.findAll(page, size);
        //modelAndView.setViewName("pages/users/users-list");
        /*if (booksResponse.getStatus().isError()) {
            modelAndView.addObject("error", booksResponse.getMessage());
        }
        modelAndView.addObject("books", booksResponse.getData());
        int totalPages = booksResponse.getData().getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }*/
        return modelAndView;
    }
}
