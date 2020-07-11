package ru.otus.springcourse05.service;

import ru.otus.springcourse05.domain.Books;

import java.sql.Date;
import java.util.List;

public interface BooksService {

    String insertBook(Books book);
    List<Books> outputListOfBooks();
    String updateYearOfBookById(int id, Date year);
    String deleteBookById(int id);
    Books getBookById(int id);

}
