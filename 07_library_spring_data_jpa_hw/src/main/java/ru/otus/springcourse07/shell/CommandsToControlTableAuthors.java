package ru.otus.springcourse07.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse07.domain.Author;
import ru.otus.springcourse07.service.AuthorsService;

import java.util.Collections;
import java.util.List;

@ShellComponent
public class CommandsToControlTableAuthors {

    private final AuthorsService authorsService;
    private final TableShell tableShell;

    public CommandsToControlTableAuthors(AuthorsService authorsService, TableShell tableShell) {
        this.authorsService = authorsService;
        this.tableShell = tableShell;
    }

    @ShellMethod(value = "Displays the entire table Authors", key = "showA")
    public Table showAllAuthors(){
        List<Author> authorsList = authorsService.outputListOfAuthors();
        if(authorsList.isEmpty()){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(authorsList, Author.class);
    }

    @ShellMethod(value = "Displays the table with author by id", key = "showAbyid")
    public Table showAuthorsById(int id){
        Author author = authorsService.getAuthorById(id);
        if(author == null){
            return tableShell.printTableError(String.format("Not found author with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(author), Author.class);
    }

    @ShellMethod(value = "Insert into authors table", key = {"insA", "insertA"})
    public void insertIntoAuthorTable(String firstname, String lastname, String country){
        Author author = new Author();
        author.setFirstname(firstname);
        author.setLastname(lastname);
        author.setCountry(country);
        authorsService.insertAuthor(author);
    }

}
