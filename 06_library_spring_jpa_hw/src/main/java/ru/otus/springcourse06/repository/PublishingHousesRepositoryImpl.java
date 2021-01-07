package ru.otus.springcourse06.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse06.domain.PublishingHouse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class PublishingHousesRepositoryImpl implements PublishingHousesRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public PublishingHousesRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PublishingHouse> getAll() {
        return entityManager.createQuery("SELECT ph FROM PublishingHouse ph", PublishingHouse.class).getResultList();
    }

    @Override
    public PublishingHouse getById(int id) {
        return entityManager.find(PublishingHouse.class, id);
    }

    @Override
    public void insert(PublishingHouse publishingHouses) {
        entityManager.persist(publishingHouses);
    }
}
