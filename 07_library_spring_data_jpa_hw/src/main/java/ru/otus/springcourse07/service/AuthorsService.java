package ru.otus.springcourse07.service;

import ru.otus.springcourse07.domain.Author;

import java.util.List;

public interface AuthorsService {

    void insertAuthor(Author author);
    List<Author> outputListOfAuthors();
    Author getAuthorById(int id);

}
