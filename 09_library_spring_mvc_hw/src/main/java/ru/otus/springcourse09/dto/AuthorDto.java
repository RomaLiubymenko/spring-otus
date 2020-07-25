package ru.otus.springcourse09.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private String country;
    private Set<BookDto> bookDtoSet;

}
