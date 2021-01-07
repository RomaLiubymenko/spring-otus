package ru.otus.springcourse05.service;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse05.dao.AuthorsDao;
import ru.otus.springcourse05.domain.Authors;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {

    private final AuthorsDao authorsDao;

    public AuthorsServiceImpl(AuthorsDao authorsDao) {
        this.authorsDao = authorsDao;
    }

    @Override
    public Authors getAuthorById(int id) {
        try {
            return authorsDao.getById(id);
        } catch (DataAccessException exception) {
            return null;
        }
    }

    @Override
    public String insertAuthor(Authors author) {
        if (authorsDao.insert(author) == 1) {
            return "You added new author: " + author.getFirstname() + author.getLastname();
        }
        return "Author was not added";
    }

    @Override
    public List<Authors> outputListOfAuthors() {
        try {
            return authorsDao.getAll();

        } catch (DataAccessException exception) {
            return null;
        }
    }
}
