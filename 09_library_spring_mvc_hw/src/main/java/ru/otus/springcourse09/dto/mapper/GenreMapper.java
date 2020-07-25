package ru.otus.springcourse09.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.otus.springcourse09.dto.GenreDto;
import ru.otus.springcourse09.model.Genre;

import java.util.List;

@Mapper
public interface GenreMapper {

    @Mappings({
            @Mapping(source = "idGenre", target = "id"),
            @Mapping(source = "bookSet", target = "bookDtoSet")
    })
    GenreDto genreToGenreDto(Genre genre);

    @Mappings({
            @Mapping(source = "id", target = "idGenre"),
            @Mapping(source = "bookDtoSet", target = "bookSet")
    })
    Genre genreDtoToGenre(GenreDto genreDto);

    List<GenreDto> genresToGenreDtos(List<Genre> genreList);
}
