package ru.otus.springcourse06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse06.domain.PublishingHouse;
import ru.otus.springcourse06.repository.PublishingHousesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishingHousesImpl implements PublishingHousesService {

    private final PublishingHousesRepository publishingHousesRepository;

    @Override
    public void insertPublishingHouses(PublishingHouse publishingHouse) {
        publishingHousesRepository.insert(publishingHouse);
    }

    @Override
    public List<PublishingHouse> outputListOfPublishingHouses() {
        return publishingHousesRepository.getAll();
    }

    @Override
    public PublishingHouse getPublishingHouseById(int id) {
       return publishingHousesRepository.getById(id);
    }

}
