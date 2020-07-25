package ru.otus.springcourse09.service;

import ru.otus.springcourse09.dto.BookDto;
import ru.otus.springcourse09.model.Book;

import java.sql.Date;
import java.util.List;

public interface BooksService {

    void insertBook(Book book);
    List<BookDto> outputListOfBooks();
    void updateYearOfBookById(int id, Date year);
    void deleteBookById(int id);
    BookDto getBookDtoById(int id);

}
