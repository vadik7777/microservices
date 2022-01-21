package ru.otus.microservices.homework17.service;

import ru.otus.microservices.homework17.dto.AuthorDto;

import java.util.List;

public interface AuthorService {

    List<AuthorDto> findAll();
}