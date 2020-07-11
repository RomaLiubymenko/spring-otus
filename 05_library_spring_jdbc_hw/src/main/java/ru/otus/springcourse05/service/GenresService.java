package ru.otus.springcourse05.service;

import ru.otus.springcourse05.domain.Genres;

import java.util.List;

public interface GenresService  {

    String insertGenre(Genres genre);
    List<Genres> outputListOfGenres();
    Genres getGenreById(int id);

}
