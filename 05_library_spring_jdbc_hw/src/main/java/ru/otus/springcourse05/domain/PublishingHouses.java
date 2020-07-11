package ru.otus.springcourse05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishingHouses {

    private int idPublishingHouse;
    private String publishingName;
    private String country;

}
