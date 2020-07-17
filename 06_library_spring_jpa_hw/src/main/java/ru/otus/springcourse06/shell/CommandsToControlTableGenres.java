package ru.otus.springcourse06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.table.Table;
import ru.otus.springcourse06.domain.Genre;
import ru.otus.springcourse06.service.GenresService;

import java.util.Collections;
import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class CommandsToControlTableGenres {

    private final GenresService genresService;
    private final TableShell tableShell;

    @ShellMethod(value = "Displays the entire table Genres", key = "showG")
    public Table showAllGenres(){
        List<Genre> genresList = genresService.outputListOfGenres();
        if(genresList.isEmpty()){
            return tableShell.printTableError("Something went wrong");
        }
        return tableShell.printTable(genresList, Genre.class);
    }

    @ShellMethod(value = "Displays the table with genres by id", key = "showGbyid")
    public Table showGenresById(int id){
        Genre genre = genresService.getGenreById(id);
        if(genre == null){
            return tableShell.printTableError(String.format("Not found genre with id: %s",id));
        }
        return tableShell.printTable(Collections.singletonList(genre), Genre.class);
    }

    @ShellMethod(value = "Insert into genres table", key = {"insG", "insertG"})
    public void insertIntoGenreTable(String nameGenre){
        Genre genre = new Genre();
        genre.setNameGenre(nameGenre);
        genresService.insertGenre(genre);
    }
}
