package ru.otus.springcourse05.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse05.domain.Books;
import ru.otus.springcourse05.service.BooksService;

import java.sql.Date;
import java.util.Collections;
import java.util.List;

@ShellComponent
public class ControlCommandsForTableBooks {

    private final BooksService booksService;
    private final TableShell tableShell;

    public ControlCommandsForTableBooks(BooksService booksService, TableShell tableShell) {
        this.booksService = booksService;
        this.tableShell = tableShell;
    }

    @ShellMethod(value = "Displays the entire table Books", key = "showB")
    public Table showAllBooks(){
        List<Books> booksList = booksService.outputListOfBooks();
        if(booksList == null){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(booksList, new Books());
    }

    @ShellMethod(value = "Displays the table with books by id", key = "showBbyid")
    public Table showBooksById(int id){
        Books book = booksService.getBookById(id);
        if(book == null){
            return tableShell.printTableError(String.format("Not found book with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(book), new Books());
    }

    @ShellMethod(value = "Insert into books table", key = {"insB", "insertB"})
    public void insertIntoBooksTable(int idAuthor, int idGenre, int idPublishingHouse, String title, Date publicationYear, int numberOfPages){
        Books books = new Books();
        books.setIdAuthor(idAuthor);
        books.setIdGenre(idGenre);
        books.setIdPublishingHouse(idPublishingHouse);
        books.setTitle(title);
        books.setPublicationYear(publicationYear);
        books.setNumberOfPages(numberOfPages);
        System.out.println(booksService.insertBook(books));
    }



    @ShellMethod(value = "Update Year Of Book By Id", key = "updYearBookbyid")
    public void updateYearOfBookById(int id, Date year) {
        String str = booksService.updateYearOfBookById(id, year);
        if(str == null){
            System.out.println("Cannot update book with id: " + id);
        }
        else{
            System.out.println(str);
        }
    }

    @ShellMethod(value = "Delete book by id", key = "delBookbyid")
    public void deleteBookById(int id, Date year) {
        String str = booksService.deleteBookById(id);
        if(str == null){
            System.out.println("Cannot delete book with id: " + id);
        }
        else{
            System.out.println(str);
        }
    }
}
