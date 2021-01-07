package ru.otus.springcourse05.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse05.domain.Authors;
import ru.otus.springcourse05.service.AuthorsService;

import java.util.Collections;
import java.util.List;

@ShellComponent
public class ControlCommandsForTableAuthors {

    private final AuthorsService authorsService;
    private final TableShell tableShell;

    public ControlCommandsForTableAuthors(AuthorsService authorsService, TableShell tableShell) {
        this.authorsService = authorsService;
        this.tableShell = tableShell;
    }

    @ShellMethod(value = "Displays the entire table Authors", key = "showA")
    public Table showAllAuthors(){
        List<Authors> authorsList = authorsService.outputListOfAuthors();
        if(authorsList == null){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(authorsList, new Authors());
    }

    @ShellMethod(value = "Displays the table with author by id", key = "showAbyid")
    public Table showAuthorsById(int id){
        Authors author = authorsService.getAuthorById(id);
        if(author == null){
            return tableShell.printTableError(String.format("Not found author with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(author), new Authors());
    }

    @ShellMethod(value = "Insert into authors table", key = {"insA", "insertA"})
    public void insertIntoAuthorTable(String firstname, String lastname, String country){
        Authors authors = new Authors();
        authors.setFirstname(firstname);
        authors.setLastname(lastname);
        authors.setCountry(country);
        System.out.println(authorsService.insertAuthor(authors));
    }

}
