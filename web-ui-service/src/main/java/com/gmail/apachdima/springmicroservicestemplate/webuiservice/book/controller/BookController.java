package com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.controller;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.dto.BookResponseDTO;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.service.BookService;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.dto.WrapperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping(value = "/dashboard/books")
    public ModelAndView books(@RequestParam("page") Integer page,
                              @RequestParam("size") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        WrapperDTO<Page<BookResponseDTO>> booksResponse = bookService.findAll(page, size);
        modelAndView.setViewName("pages/books/books-list");
        if (booksResponse.getStatus().isError()) {
            modelAndView.addObject("error", booksResponse.getMessage());
        }
        modelAndView.addObject("books", booksResponse.getData());
        int totalPages = booksResponse.getData().getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }
        return modelAndView;
    }
}
