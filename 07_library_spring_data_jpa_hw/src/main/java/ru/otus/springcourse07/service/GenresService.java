package ru.otus.springcourse07.service;

import ru.otus.springcourse07.domain.Genre;

import java.util.List;

public interface GenresService  {

    void insertGenre(Genre genre);
    List<Genre> outputListOfGenres();
    Genre getGenreById(int id);

}
