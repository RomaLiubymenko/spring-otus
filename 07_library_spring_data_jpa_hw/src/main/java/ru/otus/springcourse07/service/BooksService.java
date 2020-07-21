package ru.otus.springcourse07.service;

import ru.otus.springcourse07.domain.Book;

import java.sql.Date;
import java.util.List;

public interface BooksService {

    void insertBook(Book book);
    List<Book> outputListOfBooks();
    void updateYearOfBookById(int id, Date year);
    void deleteBookById(int id);
    Book getBookById(int id);

}
