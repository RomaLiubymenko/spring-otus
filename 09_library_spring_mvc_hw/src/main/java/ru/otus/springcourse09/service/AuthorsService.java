package ru.otus.springcourse09.service;

import ru.otus.springcourse09.dto.AuthorDto;

import java.util.List;

public interface AuthorsService {

    void insertAuthorDto(AuthorDto authorDto);
    List<AuthorDto> outputListOfAuthorsDto();
    AuthorDto getAuthorDtoById(int id);

}
