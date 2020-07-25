package ru.otus.springcourse09.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.otus.springcourse09.dto.PublishingHouseDto;
import ru.otus.springcourse09.model.PublishingHouse;

import java.util.List;

@Mapper
public interface PublishingHouseMapper {

    @Mappings({
            @Mapping(source = "idPublishingHouse", target = "id"),
            @Mapping(source = "bookSet", target = "bookDtoSet")
    })
    PublishingHouseDto publishHouseToPublishingHouseDto(PublishingHouse publishingHouse);

    @Mappings({
            @Mapping(source = "id", target = "idPublishingHouse"),
            @Mapping(source = "bookDtoSet", target = "bookSet")
    })
    PublishingHouse publishHouseDtoToPublishingHouse(PublishingHouseDto publishingHouseDto);

    List<PublishingHouseDto> publishHousesToPublishingHouseDtos(List<PublishingHouse> publishingHouseList);
}
