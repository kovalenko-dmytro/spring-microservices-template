package com.abcloudz.springmicroservicestemplate.webuiservice.book.client;

import com.abcloudz.springmicroservicestemplate.webuiservice.book.dto.BookResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "book-service", url = "${client.book-service.base-uri}")
public interface BookServiceClient {

    @GetMapping(value = "/api/v1/books")
    ResponseEntity<Page<BookResponseDTO>> findAll(Pageable pageable);
}
