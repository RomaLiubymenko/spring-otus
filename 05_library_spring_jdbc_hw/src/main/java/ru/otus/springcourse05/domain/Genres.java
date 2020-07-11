package ru.otus.springcourse05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Genres {

    private int idGenre;
    private String nameGenre;

}
