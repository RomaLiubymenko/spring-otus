package ru.otus.springcourse06.repository;

import ru.otus.springcourse06.domain.Author;

import java.util.List;

public interface AuthorsRepository {

    void insert(Author author);
    List<Author> getAll();
    Author getById(int id);

}
