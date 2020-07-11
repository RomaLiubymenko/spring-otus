package ru.otus.springcourse05.dao;

import ru.otus.springcourse05.domain.Books;

import java.sql.Date;
import java.util.List;

public interface BooksDao {

    int insert(Books books);
    List<Books> getAll();
    int updateYearById(int id, Date year);
    int deleteById(int id);
    Books getById(int id);

}
