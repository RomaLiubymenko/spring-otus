package ru.otus.springcourse05.dao;

import ru.otus.springcourse05.domain.Genres;

import java.util.List;

public interface GenresDao {

    int insert(Genres genres);
    List<Genres> getAll();
    Genres getById(int id);

}
