package com.abcloudz.springmicroservicestemplate.webuiservice.book.service.impl;

import com.abcloudz.springmicroservicestemplate.webuiservice.book.client.BookServiceClient;
import com.abcloudz.springmicroservicestemplate.webuiservice.book.dto.BookResponseDTO;
import com.abcloudz.springmicroservicestemplate.webuiservice.book.service.BookService;
import com.abcloudz.springmicroservicestemplate.webuiservice.common.dto.WrapperDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookServiceClient client;

    @Override
    public WrapperDTO<Page<BookResponseDTO>> findAll(Integer page, Integer size) {
        int currentPage = Optional.ofNullable(page).orElse(1);
        int pageSize = Optional.ofNullable(size).orElse(5);
        Pageable pageRequest = PageRequest.of(currentPage - 1, pageSize);
        ResponseEntity<Page<BookResponseDTO>> response = client.findAll(pageRequest);
        return WrapperDTO.<Page<BookResponseDTO>>builder()
            .status(response.getStatusCode())
            .data(response.getBody())
            .build();
    }
}
