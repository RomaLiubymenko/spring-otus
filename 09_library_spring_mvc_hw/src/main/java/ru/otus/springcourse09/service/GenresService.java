package ru.otus.springcourse09.service;

import ru.otus.springcourse09.model.Genre;

import java.util.List;

public interface GenresService  {

    void insertGenre(Genre genre);
    List<Genre> outputListOfGenres();
    Genre getGenreById(int id);

}
