package com.abcloudz.springmicroservicestemplate.webuiservice.book.service;

import com.abcloudz.springmicroservicestemplate.webuiservice.book.dto.BookResponseDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.common.dto.WrapperDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface BookService {

    WrapperDTO<Page<BookResponseDTO>> findAll(Integer page, Integer size);
}
