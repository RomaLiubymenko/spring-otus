package ru.otus.springcourse10.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse10.dto.BookDto;
import ru.otus.springcourse10.dto.mapper.BookMapper;
import ru.otus.springcourse10.model.Book;
import ru.otus.springcourse10.repository.BooksRepository;
import ru.otus.springcourse10.service.BooksService;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final BookMapper bookMapper;

    @Override
    public void insertBookDto(BookDto bookDto) {
        Book book = bookMapper.bookDtoToBook(bookDto);
        booksRepository.save(book);
    }

    @Override
    public List<BookDto> outputListOfBooksDtos() {
        List<Book> bookList = booksRepository.findAll();
        return  bookMapper.booksToBookDtos(bookList);
    }

    @Override
    public void updateYearOfBookDtoById(int id, Date year) {
        booksRepository.updateYearBookById(id, year);
    }

    @Override
    public void deleteBookDtoById(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public BookDto getBookDtoById(int id) {
        Book book = booksRepository.getOne(id);
        return bookMapper.bookToBookDto(book);
    }

}
