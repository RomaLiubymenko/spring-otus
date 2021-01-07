package ru.otus.springcourse06.service;

import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.Genre;
import ru.otus.springcourse06.repository.GenresRepository;

import java.util.List;

@Service
public class GenresServiceImpl implements GenresService {

    private final GenresRepository genresRepository;

    public GenresServiceImpl(GenresRepository genresRepository) {
        this.genresRepository = genresRepository;
    }

    @Override
    public void insertGenre(Genre genre) {
        genresRepository.insert(genre);
    }

    @Override
    public List<Genre> outputListOfGenres() {
        return genresRepository.getAll();
    }

    @Override
    public Genre getGenreById(int id) {
        return genresRepository.getById(id);
    }
}
