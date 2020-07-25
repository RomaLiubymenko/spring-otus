package ru.otus.springcourse09.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse09.dto.BookDto;
import ru.otus.springcourse09.dto.mapper.BookMapper;
import ru.otus.springcourse09.model.Book;
import ru.otus.springcourse09.repository.BooksRepository;
import ru.otus.springcourse09.service.BooksService;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final BookMapper bookMapper;

    @Override
    public void insertBook(Book book) {
        booksRepository.save(book);
    }

    @Override
    public List<BookDto> outputListOfBooks() {
        List<Book> bookList = booksRepository.findAll();
        return  bookMapper.booksToBookDtos(bookList);
    }

    @Override
    public void updateYearOfBookById(int id, Date year) {
        booksRepository.updateYearBookById(id, year);
    }

    @Override
    public void deleteBookById(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public BookDto getBookDtoById(int id) {
        Book book = booksRepository.getOne(id);
        return bookMapper.bookToBookDto(book);
    }

}
