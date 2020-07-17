package ru.otus.springcourse06.service;

import ru.otus.springcourse06.domain.PublishingHouse;

import java.util.List;

public interface PublishingHousesService  {

    void insertPublishingHouses(PublishingHouse publishingHouse);
    List<PublishingHouse> outputListOfPublishingHouses();
    PublishingHouse getPublishingHouseById(int id);

}
