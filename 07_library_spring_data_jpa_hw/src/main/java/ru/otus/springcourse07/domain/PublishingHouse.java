package ru.otus.springcourse07.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PublishingHouses")
public class PublishingHouse {

    @Id
    @Column(name = "idPublishingHouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublishingHouse;

    @Column(name = "publishingName", nullable = false, length = 100)
    private String publishingName;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "publishingHouse")
    private List<Book> bookList;

    public int getIdPublishingHouse() {
        return idPublishingHouse;
    }

    public void setIdPublishingHouse(int idPublishingHouse) {
        this.idPublishingHouse = idPublishingHouse;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        this.publishingName = publishingName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return idPublishingHouse == that.idPublishingHouse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublishingHouse);
    }

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "idPublishingHouse=" + idPublishingHouse +
                ", publishingName='" + publishingName + '\'' +
                ", country='" + country + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
