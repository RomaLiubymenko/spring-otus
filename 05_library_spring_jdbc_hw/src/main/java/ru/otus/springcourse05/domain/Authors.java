package ru.otus.springcourse05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authors {

    private int idAuthor;
    private String firstname;
    private String lastname;
    private String country;

}

