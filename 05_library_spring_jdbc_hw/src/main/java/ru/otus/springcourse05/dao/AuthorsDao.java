package ru.otus.springcourse05.dao;

import ru.otus.springcourse05.domain.Authors;

import java.util.List;

public interface AuthorsDao {

    int insert(Authors authors);
    List<Authors> getAll();
    Authors getById(int id);

}
