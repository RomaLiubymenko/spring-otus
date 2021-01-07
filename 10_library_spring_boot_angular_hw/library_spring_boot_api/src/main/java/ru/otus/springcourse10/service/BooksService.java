package ru.otus.springcourse10.service;

import ru.otus.springcourse10.dto.BookDto;

import java.sql.Date;
import java.util.List;

public interface BooksService {

    void insertBookDto(BookDto bookDto);
    List<BookDto> outputListOfBooksDtos();
    void updateYearOfBookDtoById(int id, Date year);
    void deleteBookDtoById(int id);
    BookDto getBookDtoById(int id);

}
