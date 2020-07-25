package ru.otus.springcourse09.dto;

import lombok.*;
import ru.otus.springcourse09.model.Book;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {

    private Integer id;
    private String nameGenre;
    private Set<Book> bookDtoSet;

}
