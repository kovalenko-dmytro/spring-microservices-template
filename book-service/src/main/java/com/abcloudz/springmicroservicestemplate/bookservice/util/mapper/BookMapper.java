package com.abcloudz.springmicroservicestemplate.bookservice.util.mapper;

import com.abcloudz.springmicroservicestemplate.bookservice.dto.book.BookResponseDTO;
import com.abcloudz.springmicroservicestemplate.bookservice.model.Book;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

    BookResponseDTO toResponseDTO(Book book);
}
