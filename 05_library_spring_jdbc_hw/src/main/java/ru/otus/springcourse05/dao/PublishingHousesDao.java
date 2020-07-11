package ru.otus.springcourse05.dao;

import ru.otus.springcourse05.domain.PublishingHouses;

import java.util.List;

public interface PublishingHousesDao {

    int insert(PublishingHouses publishingHouses);
    List<PublishingHouses> getAll();
    PublishingHouses getById(int id);

}
