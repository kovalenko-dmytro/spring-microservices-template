package com.gmail.apachdima.springmicroservicestemplate.bookservice.util.mapper;

import com.gmail.apachdima.springmicroservicestemplate.bookservice.dto.book.BookResponseDTO;
import com.gmail.apachdima.springmicroservicestemplate.bookservice.model.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookResponseDTO toResponseDTO(Book book);
}
