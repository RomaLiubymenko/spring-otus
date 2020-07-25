package ru.otus.springcourse09.service;

import ru.otus.springcourse09.model.PublishingHouse;

import java.util.List;

public interface PublishingHousesService  {

    void insertPublishingHouses(PublishingHouse publishingHouse);
    List<PublishingHouse> outputListOfPublishingHouses();
    PublishingHouse getPublishingHouseById(int id);

}
