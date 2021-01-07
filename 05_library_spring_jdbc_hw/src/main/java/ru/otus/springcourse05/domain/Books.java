package ru.otus.springcourse05.domain;

import java.sql.Date;
import java.util.Objects;

public class Books {

    private int idBook;
    private int idAuthor;
    private int idGenre;
    private int idPublishingHouse;
    private String title;
    private Date publicationYear;
    private int numberOfPages;

    public Books() {
    }

    public Books(int idBook, int idAuthor, int idGenre, int idPublishingHouse, String title, Date publicationYear, int numberOfPages) {
        this.idBook = idBook;
        this.idAuthor = idAuthor;
        this.idGenre = idGenre;
        this.idPublishingHouse = idPublishingHouse;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberOfPages = numberOfPages;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public int getIdPublishingHouse() {
        return idPublishingHouse;
    }

    public void setIdPublishingHouse(int idPublishingHouse) {
        this.idPublishingHouse = idPublishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return idBook == books.idBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook);
    }

    @Override
    public String toString() {
        return "Books{" +
                "idBook=" + idBook +
                ", idAuthor=" + idAuthor +
                ", idGenre=" + idGenre +
                ", idPublishingHouse=" + idPublishingHouse +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
