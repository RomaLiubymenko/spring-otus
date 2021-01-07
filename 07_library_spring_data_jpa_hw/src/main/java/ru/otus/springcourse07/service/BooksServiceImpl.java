package ru.otus.springcourse07.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse07.domain.Book;
import ru.otus.springcourse07.repository.BooksRepository;

import java.sql.Date;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void insertBook(Book book) {
        booksRepository.save(book);
    }

    @Override
    public List<Book> outputListOfBooks() {
        return booksRepository.findAll();
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
    public Book getBookById(int id) {
        return booksRepository.getOne(id);
    }

}
