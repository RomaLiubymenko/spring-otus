package ru.otus.springcourse06.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse06.domain.Book;
import ru.otus.springcourse06.domain.PublishingHouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class BooksRepositoryJpaImpl implements BooksRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    private final AuthorsRepository authorsRepository;
    private final GenresRepository genresRepository;
    private final PublishingHousesRepository publishingHousesRepository;

    @Override
    public List<Book> getAll() {
        return entityManager.createQuery("SELECT book FROM Book book", Book.class).getResultList();
    }

    @Override
    public void insert(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    public void deleteById(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }

    @Override
    public Book getById(int id) {
        return entityManager.find(Book.class,id);
    }
}
