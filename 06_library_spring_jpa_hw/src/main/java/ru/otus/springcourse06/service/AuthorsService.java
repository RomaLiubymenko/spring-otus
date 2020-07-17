package ru.otus.springcourse06.service;

import ru.otus.springcourse06.domain.Author;

import java.util.List;

public interface AuthorsService {

    void insertAuthor(Author author);
    List<Author> outputListOfAuthors();
    Author getAuthorById(int id);

}
