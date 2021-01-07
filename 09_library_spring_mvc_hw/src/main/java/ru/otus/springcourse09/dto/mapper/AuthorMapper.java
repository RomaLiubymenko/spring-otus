package ru.otus.springcourse09.dto.mapper;


import org.springframework.stereotype.Service;
import ru.otus.springcourse09.dto.AuthorDto;
import ru.otus.springcourse09.model.Author;

import java.util.List;

@Service
public class AuthorMapper implements AbstractMapper<AuthorDto, Author>  {


    @Override
    public Author toEntity(AuthorDto authorDto) {
        return null;
    }

    @Override
    public AuthorDto toDto(Author author) {
        return null;
    }

    @Override
    public List<Author> toEntity(List<AuthorDto> authorDtos) {
        return null;
    }

    @Override
    public List<AuthorDto> toDto(List<Author> authors) {
        return null;
    }
}
