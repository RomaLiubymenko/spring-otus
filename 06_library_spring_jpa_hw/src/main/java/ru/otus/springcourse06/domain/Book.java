package ru.otus.springcourse06.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "idBook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;

    @ManyToOne
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "idGenre", nullable = false)
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "idPublishingHouse", nullable = false)
    private PublishingHouse publishingHouse;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(name = "publicationYear", nullable = false)
    private Date publicationYear;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book")
    @ToString.Exclude
    private List<Comment> commentList;

    @Override
    public String toString(){
        return String.valueOf(this.getIdBook());
    }
}

