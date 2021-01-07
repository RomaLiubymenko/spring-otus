package ru.otus.springcourse06.service;

import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.Author;
import ru.otus.springcourse06.repository.AuthorsRepository;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsRepository authorsRepository;

    public AuthorsServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

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
