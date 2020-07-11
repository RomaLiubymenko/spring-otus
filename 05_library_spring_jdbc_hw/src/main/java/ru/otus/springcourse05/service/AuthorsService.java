package ru.otus.springcourse05.service;

import ru.otus.springcourse05.domain.Authors;

import java.util.List;

public interface AuthorsService {

    String insertAuthor(Authors author);
    List<Authors> outputListOfAuthors();
    Authors getAuthorById(int id);

}
