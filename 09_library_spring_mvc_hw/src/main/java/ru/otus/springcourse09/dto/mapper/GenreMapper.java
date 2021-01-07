package ru.otus.springcourse09.dto.mapper;

import org.springframework.stereotype.Service;
import ru.otus.springcourse09.dto.GenreDto;
import ru.otus.springcourse09.model.Genre;

import java.util.List;

@Service
public class GenreMapper implements AbstractMapper<GenreDto, Genre> {

    @Override
    public Genre toEntity(GenreDto genreDto) {
        return null;
    }

    @Override
    public GenreDto toDto(Genre genre) {
        return null;
    }

    @Override
    public List<Genre> toEntity(List<GenreDto> genreDtos) {
        return null;
    }

    @Override
    public List<GenreDto> toDto(List<Genre> genres) {
        return null;
    }
}
