package ru.otus.springcourse05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private int idBook;
    private int idAuthor;
    private int idGenre;
    private int idPublishingHouse;
    private String title;
    private Date publicationYear;
    private int numberOfPages;

}
