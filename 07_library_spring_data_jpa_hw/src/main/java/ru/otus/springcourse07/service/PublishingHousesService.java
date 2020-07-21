package ru.otus.springcourse07.service;

import ru.otus.springcourse07.domain.PublishingHouse;

import java.util.List;

public interface PublishingHousesService  {

    void insertPublishingHouses(PublishingHouse publishingHouse);
    List<PublishingHouse> outputListOfPublishingHouses();
    PublishingHouse getPublishingHouseById(int id);

}
