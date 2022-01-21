package ru.otus.microservices.homework17.service;

import ru.otus.microservices.homework17.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDto create(BookDto bookDto);

    Optional<BookDto> update(long id, BookDto bookDto);

    Optional<BookDto> findById(long id);

    List<BookDto> findAll();

    void delete(BookDto bookDto);

}