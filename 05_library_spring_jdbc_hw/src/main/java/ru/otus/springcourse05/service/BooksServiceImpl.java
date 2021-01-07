package ru.otus.springcourse05.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse05.dao.BooksDao;
import ru.otus.springcourse05.domain.Books;

import java.sql.Date;
import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksDao booksDao;
    private final AuthorsService authorsService;
    private final GenresService genresService;
    private final PublishingHousesService publishingHousesService;

    public BooksServiceImpl(BooksDao booksDao, AuthorsService authorsService, GenresService genresService, PublishingHousesService publishingHousesService) {
        this.booksDao = booksDao;
        this.authorsService = authorsService;
        this.genresService = genresService;
        this.publishingHousesService = publishingHousesService;
    }

    @Override
    public String insertBook(Books book) {
        if (authorsService.getAuthorById(book.getIdAuthor()) == null) {
            return  "In the first create first an author";
        } else if (genresService.getGenreById(book.getIdGenre()) == null) {
            return  "In the first create first an genre";
        } else if (publishingHousesService.getPublishingHouseById(book.getIdPublishingHouse()) == null) {
            return  "In the first create first an publishingHouses";
        } else {
            if (booksDao.insert(book) == 1) {
                return "You added new book: " + book.getTitle();
            }
            return "Book was not added";
        }
    }

    @Override
    public List<Books> outputListOfBooks() {
        try {
            return booksDao.getAll();

        } catch (DataAccessException exception) {
            return null;
        }
    }

    @Override
    public String updateYearOfBookById(int id, Date year) {
        try {
            if (booksDao.updateYearById(id, year) == 1) {
                return "You update book with id: " + id;
            }
            return "Book was not updated";
        }catch (DataAccessException exception){
            return null;
        }
    }

    @Override
    public String deleteBookById(int id) {
        try {
            if (booksDao.deleteById(id) == 1) {
                return "You delete book with id: " + id;
            }
            return "Book was not deleted";
        }catch (DataAccessException exception){
            return null;
        }
    }

    @Override
    public Books getBookById(int id) {
        try {
            return booksDao.getById(id);
        } catch (DataAccessException exception) {
            return null;
        }
    }


}
