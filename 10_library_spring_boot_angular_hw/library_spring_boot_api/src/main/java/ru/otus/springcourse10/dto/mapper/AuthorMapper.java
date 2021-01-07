package ru.otus.springcourse10.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.otus.springcourse10.model.Author;
import ru.otus.springcourse10.dto.AuthorDto;

import java.util.List;

@Mapper
public interface AuthorMapper {

    @Mappings({
            @Mapping(source = "idAuthor", target = "id"),
            @Mapping(source = "bookSet", target = "bookDtoSet")
    })
    AuthorDto authorToAuthorDto(Author author);

    @Mappings({
            @Mapping(source = "id", target = "idAuthor"),
            @Mapping(source = "bookDtoSet", target = "bookSet")
    })
    Author authorDtoToAuthor(AuthorDto authorDto);

    List<AuthorDto> authorsToAuthorDtos(List<Author> authorList);

}
