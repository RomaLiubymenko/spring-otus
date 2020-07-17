package ru.otus.springcourse06.repository;

import ru.otus.springcourse06.domain.PublishingHouse;

import java.util.List;

public interface PublishingHousesRepository {

    void insert(PublishingHouse publishingHouses);
    List<PublishingHouse> getAll();
    PublishingHouse getById(int id);

}
