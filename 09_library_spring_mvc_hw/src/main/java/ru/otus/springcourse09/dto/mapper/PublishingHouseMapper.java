package ru.otus.springcourse09.dto.mapper;


import org.springframework.stereotype.Service;
import ru.otus.springcourse09.dto.PublishingHouseDto;
import ru.otus.springcourse09.model.PublishingHouse;

import java.util.List;

@Service
public class PublishingHouseMapper implements AbstractMapper<PublishingHouseDto, PublishingHouse> {

    @Override
    public PublishingHouse toEntity(PublishingHouseDto publishingHouseDto) {
        return null;
    }

    @Override
    public PublishingHouseDto toDto(PublishingHouse publishingHouse) {
        return null;
    }

    @Override
    public List<PublishingHouse> toEntity(List<PublishingHouseDto> publishingHouseDtos) {
        return null;
    }

    @Override
    public List<PublishingHouseDto> toDto(List<PublishingHouse> publishingHouses) {
        return null;
    }
}
