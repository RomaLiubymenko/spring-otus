package ru.otus.springcourse06.service;

import ru.otus.springcourse06.domain.Book;

import java.sql.Date;
import java.util.List;

public interface BooksService {

    void insertBook(Book book);
    List<Book> outputListOfBooks();
    void updateYearOfBookById(int id, Date year);
    void deleteBookById(int id);
    Book getBookById(int id);

}
