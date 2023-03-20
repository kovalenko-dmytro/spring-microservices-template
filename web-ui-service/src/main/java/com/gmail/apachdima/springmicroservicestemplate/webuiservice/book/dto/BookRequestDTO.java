package com.gmail.apachdima.springmicroservicestemplate.webuiservice.book.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookRequestDTO {

    @NotBlank
    private String author;
    @NotBlank
    private String title;
}
