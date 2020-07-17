package ru.otus.springcourse06.repository;

import ru.otus.springcourse06.domain.Book;

import java.util.List;

public interface BooksRepository {

    void insert(Book book);
    List<Book> getAll();
    void update(Book book);
    void deleteById(int id);
    Book getById(int id);

}
