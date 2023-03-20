package com.gmail.apachdima.springmicroservicestemplate.bookservice.repository;

import com.gmail.apachdima.springmicroservicestemplate.bookservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
