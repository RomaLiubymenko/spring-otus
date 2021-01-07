package ru.otus.springcourse06.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse06.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class GenresRepositoryImpl implements GenresRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public GenresRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Genre> getAll() {
        return entityManager.createQuery("SELECT genre FROM Genre genre", Genre.class).getResultList();
    }

    @Override
    public Genre getById(int id) {
        return entityManager.find(Genre.class, id);
    }

    @Override
    public void insert(Genre genres) {
        entityManager.persist(genres);
    }
}
