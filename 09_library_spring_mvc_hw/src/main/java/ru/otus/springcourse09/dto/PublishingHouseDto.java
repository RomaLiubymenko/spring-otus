package ru.otus.springcourse09.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublishingHouseDto {

    private Integer id;
    private String publishingName;
    private String country;
    private Set<BookDto> bookDtoSet;
}
