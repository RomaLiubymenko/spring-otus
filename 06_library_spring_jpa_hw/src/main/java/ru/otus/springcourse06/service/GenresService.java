package ru.otus.springcourse06.service;

import ru.otus.springcourse06.domain.Genre;

import java.util.List;

public interface GenresService  {

    void insertGenre(Genre genre);
    List<Genre> outputListOfGenres();
    Genre getGenreById(int id);

}
