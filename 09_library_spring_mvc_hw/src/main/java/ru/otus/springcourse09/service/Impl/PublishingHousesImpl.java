package ru.otus.springcourse09.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.springcourse09.model.PublishingHouse;
import ru.otus.springcourse09.repository.PublishingHousesRepository;
import ru.otus.springcourse09.service.PublishingHousesService;

import java.util.List;

@Service
@Transactional
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
