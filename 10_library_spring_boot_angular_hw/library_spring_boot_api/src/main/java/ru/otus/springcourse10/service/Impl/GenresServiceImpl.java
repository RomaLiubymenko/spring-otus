package ru.otus.springcourse10.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse10.model.Genre;
import ru.otus.springcourse10.repository.GenresRepository;
import ru.otus.springcourse10.service.GenresService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GenresServiceImpl implements GenresService {

    private final GenresRepository genresRepository;

    @Override
    public void insertGenre(Genre genre) {
        genresRepository.save(genre);
    }

    @Override
    public List<Genre> outputListOfGenres() {
        return genresRepository.findAll();
    }

    @Override
    public Genre getGenreById(int id) {
        return genresRepository.getOne(id);
    }
}
