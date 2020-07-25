package ru.otus.springcourse09.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Integer id;
    private AuthorDto authorDto;
    private GenreDto genreDto;
    private PublishingHouseDto publishingHouseDto;
    private String title;
    private String publicationYear;
    private int numberOfPages;
    private Set<CommentDto> commentDtoSet;

}
