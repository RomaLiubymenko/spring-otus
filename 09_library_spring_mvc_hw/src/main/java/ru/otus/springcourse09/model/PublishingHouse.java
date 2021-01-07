package ru.otus.springcourse09.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PublishingHouses")
public class PublishingHouse {

    @Id
    @Column(name = "idPublishingHouse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublishingHouse;

    @Column( name = "publishingName", nullable = false, length = 100)
    private String publishingName;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "publishingHouse")
    private Set<Book> bookSet = new HashSet<>();

    public void addBook(Book book){
        bookSet.add(book);
        book.setPublishingHouse(this);
    }

    public void removeBook(Book book){
        bookSet.remove(book);
        book.setPublishingHouse(null);
    }

    public Integer getIdPublishingHouse() {
        return idPublishingHouse;
    }

    public void setIdPublishingHouse(Integer idPublishingHouse) {
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

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishingHouse that = (PublishingHouse) o;
        return Objects.equals(idPublishingHouse, that.idPublishingHouse);
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
                ", bookSet=" + bookSet +
                '}';
    }
}
