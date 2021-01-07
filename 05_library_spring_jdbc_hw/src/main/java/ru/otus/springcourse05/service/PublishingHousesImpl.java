package ru.otus.springcourse05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.otus.springcourse05.dao.PublishingHousesDao;
import ru.otus.springcourse05.domain.PublishingHouses;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublishingHousesImpl implements PublishingHousesService {

    private final PublishingHousesDao publishingHousesDao;


    @Override
    public String insertPublishingHouses(PublishingHouses publishingHouse) {
        if (publishingHousesDao.insert(publishingHouse) == 1) {
            return "You added new Publishing House: " + publishingHouse.getPublishingName();
        }
        return "PublishingHouses was not added";
    }

    @Override
    public List<PublishingHouses> outputListOfPublishingHouses() {
        try {
            return publishingHousesDao.getAll();

        } catch (DataAccessException exception) {
            return null;
        }
    }

    @Override
    public PublishingHouses getPublishingHouseById(int id) {
        try {
            return publishingHousesDao.getById(id);
        } catch (DataAccessException exception) {
            return null;
        }
    }

}
