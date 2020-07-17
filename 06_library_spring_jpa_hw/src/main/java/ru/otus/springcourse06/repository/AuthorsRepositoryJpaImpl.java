package ru.otus.springcourse06.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse06.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class AuthorsRepositoryJpaImpl implements AuthorsRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Author> getAll() {
        return entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
    }

    @Override
    public Author getById(int id) {
        return entityManager.find(Author.class,id);
    }

    @Override
    public void insert(Author author) {
        entityManager.persist(author);
    }

}


