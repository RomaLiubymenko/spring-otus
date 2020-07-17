package ru.otus.springcourse06.repository;

import ru.otus.springcourse06.domain.Genre;

import java.util.List;

public interface GenresRepository {

    void insert(Genre genres);
    List<Genre> getAll();
    Genre getById(int id);

}
