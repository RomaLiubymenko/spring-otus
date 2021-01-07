package ru.otus.springcourse10.service;

import ru.otus.springcourse10.model.Genre;

import java.util.List;

public interface GenresService  {

    void insertGenre(Genre genre);
    List<Genre> outputListOfGenres();
    Genre getGenreById(int id);

}
