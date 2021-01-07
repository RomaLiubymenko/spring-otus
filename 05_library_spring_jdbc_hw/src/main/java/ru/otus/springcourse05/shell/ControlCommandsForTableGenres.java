package ru.otus.springcourse05.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse05.domain.Genres;
import ru.otus.springcourse05.service.GenresService;

import java.util.Collections;
import java.util.List;

@ShellComponent
public class ControlCommandsForTableGenres {

    private final GenresService genresService;
    private final TableShell tableShell;

    public ControlCommandsForTableGenres(GenresService genresService, TableShell tableShell) {
        this.genresService = genresService;
        this.tableShell = tableShell;
    }

    @ShellMethod(value = "Displays the entire table Genres", key = "showG")
    public Table showAllGenres(){
        List<Genres> genresList = genresService.outputListOfGenres();
        if(genresList == null){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(genresList, new Genres());
    }

    @ShellMethod(value = "Displays the table with genres by id", key = "showGbyid")
    public Table showGenresById(int id){
        Genres genres = genresService.getGenreById(id);
        if(genres == null){
            return tableShell.printTableError(String.format("Not found genre with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(genres), new Genres());
    }

    @ShellMethod(value = "Insert into genres table", key = {"insG", "insertG"})
    public void insertIntoGenreTable(String nameGenre){
        Genres genre = new Genres();
        genre.setNameGenre(nameGenre);
        System.out.println(genresService.insertGenre(genre));
    }
}
