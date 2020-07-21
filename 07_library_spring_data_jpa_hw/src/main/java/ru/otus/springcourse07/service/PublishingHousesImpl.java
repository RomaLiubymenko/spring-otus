package ru.otus.springcourse07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse07.domain.PublishingHouse;
import ru.otus.springcourse07.repository.PublishingHousesRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PublishingHousesImpl implements PublishingHousesService {

    private final PublishingHousesRepository publishingHousesRepository;

    @Override
    public void insertPublishingHouses(PublishingHouse publishingHouse) {
        publishingHousesRepository.save(publishingHouse);
    }

    @Override
    public List<PublishingHouse> outputListOfPublishingHouses() {
        return publishingHousesRepository.findAll();
    }

    @Override
    public PublishingHouse getPublishingHouseById(int id) {
       return publishingHousesRepository.getOne(id);
    }

}
