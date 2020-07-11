package ru.otus.springcourse05.service;

import ru.otus.springcourse05.domain.PublishingHouses;

import java.util.List;

public interface PublishingHousesService  {

    String insertPublishingHouses(PublishingHouses publishingHouse);
    List<PublishingHouses> outputListOfPublishingHouses();
    PublishingHouses getPublishingHouseById(int id);

}
