package ru.otus.springcourse06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse06.domain.Book;
import ru.otus.springcourse06.service.AuthorsService;
import ru.otus.springcourse06.service.BooksService;
import ru.otus.springcourse06.service.GenresService;
import ru.otus.springcourse06.service.PublishingHousesService;

import java.util.Collections;
import java.sql.Date;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class CommandsToControlTableBooks {

    private final BooksService booksService;
    private final AuthorsService authorsService;
    private final GenresService genresService;
    private final PublishingHousesService publishingHousesService;
    private final TableShell tableShell;

    @ShellMethod(value = "Displays the entire table Books", key = "showB")
    public Table showAllBooks() {
        List<Book> booksList = booksService.outputListOfBooks();
        if (booksList.isEmpty()) {
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(booksList, Book.class);
    }

    @ShellMethod(value = "Displays the table with books by id", key = "showBbyid")
    public Table showBooksById(int id) {
        Book book = booksService.getBookById(id);
        if (book == null) {
            return tableShell.printTableError(String.format("Not found book with id: %s", id));
        }
        return tableShell.printTable(Collections.singletonList(book), Book.class);
    }

    @ShellMethod(value = "Insert into books table", key = {"insB", "insertB"})
    public void insertIntoBooksTable(int idAuthor, int idGenre, int idPublishingHouse, String title, Date publicationYear, int numberOfPages) {
        Book book = new Book();
        if (authorsService.getAuthorById(idAuthor) == null) {
            System.out.println("In the first create an author");
        } else if (genresService.getGenreById(idGenre) == null) {
            System.out.println("In the first create an genre");
        } else if (publishingHousesService.getPublishingHouseById(idPublishingHouse) == null) {
            System.out.println("In the first create an publishingHouses");
        } else {
            book.setAuthor(authorsService.getAuthorById(idAuthor));
            book.setGenre(genresService.getGenreById(idGenre));
            book.setPublishingHouse(publishingHousesService.getPublishingHouseById(idPublishingHouse));
            book.setTitle(title);
            book.setPublicationYear(publicationYear);
            book.setNumberOfPages(numberOfPages);
            booksService.insertBook(book);
            System.out.println("The insert was successful");
        }
    }

    @ShellMethod(value = "Update Year Of Book By Id", key = "updYearBookbyid")
    public void updateYearOfBookById(int id, Date year) {
        booksService.updateYearOfBookById(id, year);
    }

    @ShellMethod(value = "Delete book by id", key = "delBookbyid")
    public void deleteBookById(int id) {
        booksService.getBookById(id);
    }


}
