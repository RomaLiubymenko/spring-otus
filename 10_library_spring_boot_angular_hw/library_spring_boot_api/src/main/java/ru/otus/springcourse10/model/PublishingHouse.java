package ru.otus.springcourse10.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PublishingHouses")
@EqualsAndHashCode(of = {"idPublishingHouse"})
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
    @ToString.Exclude
    private Set<Book> bookSet = new HashSet<>();

    public void addBook(Book book){
        bookSet.add(book);
        book.setPublishingHouse(this);
    }

    public void removeBook(Book book){
        bookSet.remove(book);
        book.setPublishingHouse(null);
    }
}
