package ru.otus.springcourse05.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse05.dao.GenresDao;
import ru.otus.springcourse05.domain.Genres;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    private final GenresDao genresDao;

    public GenresServiceImpl(GenresDao genresDao) {
        this.genresDao = genresDao;
    }

    @Override
    public String insertGenre(Genres genre) {
        if(genresDao.insert(genre) == 1){
            return "You added new genre: " + genre.getNameGenre();
        }
        return "Genre was not added";
    }

    @Override
    public List<Genres> outputListOfGenres() {
        try {
            return genresDao.getAll();

        } catch (DataAccessException exception) {
            return null;
        }
    }

    @Override
    public Genres getGenreById(int id) {
        try {
            return genresDao.getById(id);
        } catch (DataAccessException exception) {
            return null;
        }
    }
}
