package ru.otus.springcourse09.dto.mapper;

import org.springframework.stereotype.Service;
import ru.otus.springcourse09.dto.BookDto;
import ru.otus.springcourse09.model.Book;

import java.util.List;

@Service
public class BookMapper implements AbstractMapper<BookDto, Book> {

    @Override
    public Book toEntity(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto toDto(Book book) {
        return null;
    }

    @Override
    public List<Book> toEntity(List<BookDto> bookDtos) {
        return null;
    }

    @Override
    public List<BookDto> toDto(List<Book> books) {
        return null;
    }
}
