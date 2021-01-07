package ru.otus.springcourse10.service;

import ru.otus.springcourse10.model.PublishingHouse;

import java.util.List;

public interface PublishingHousesService  {

    void insertPublishingHouses(PublishingHouse publishingHouse);
    List<PublishingHouse> outputListOfPublishingHouses();
    PublishingHouse getPublishingHouseById(int id);

}
