package com.abcloudz.springmicroservicestemplate.webuiservice.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookResponseDTO {

    private long bookId;
    private String author;
    private String title;
    private LocalDateTime addedAt;
}
