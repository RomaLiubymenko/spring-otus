package ru.otus.springcourse06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.Author;
import ru.otus.springcourse06.repository.AuthorsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;

    @Override
    public Author getAuthorById(int id) {
        return authorsRepository.getById(id);
    }

    @Override
    public void insertAuthor(Author author) {
        authorsRepository.insert(author);
    }

    @Override
    public List<Author> outputListOfAuthors() {
        return authorsRepository.getAll();
    }
}
