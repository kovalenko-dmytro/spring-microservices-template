package com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.service;

import com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.dto.BookResponseDTO;
import com.gmail.apachdima.springmicroservicestemplate.webuiservice.common.dto.WrapperDTO;
import org.springframework.data.domain.Page;

public interface BookService {

    WrapperDTO<Page<BookResponseDTO>> findAll(Integer page, Integer size);
}
