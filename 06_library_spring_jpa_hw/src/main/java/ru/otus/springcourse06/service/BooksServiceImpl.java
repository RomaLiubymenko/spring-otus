package ru.otus.springcourse06.service;

import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.Book;
import ru.otus.springcourse06.repository.BooksRepository;

import java.sql.Date;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public void insertBook(Book book) {
        booksRepository.insert(book);
    }

    @Override
    public List<Book> outputListOfBooks() {
        return booksRepository.getAll();
    }

    @Override
    public void updateYearOfBookById(int id, Date year) {
        Book book = new Book();
        book.setPublicationYear(year);
        booksRepository.update(book);
    }

    @Override
    public void deleteBookById(int id) {
        booksRepository.deleteById(id);
    }

    @Override
    public Book getBookById(int id) {
        return booksRepository.getById(id);
    }

}
