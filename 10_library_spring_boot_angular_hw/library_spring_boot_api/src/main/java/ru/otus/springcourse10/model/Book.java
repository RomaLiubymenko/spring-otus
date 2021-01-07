package ru.otus.springcourse10.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Books")
@EqualsAndHashCode(of = {"idBook"})
public class Book {

    @Id
    @Column(name = "idBook")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBook;

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
    private LocalDate publicationYear;

    @Column(name = "numberOfPages")
    private int numberOfPages;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "book", orphanRemoval = true)
    @ToString.Exclude
    private Set<Comment> commentSet = new HashSet<>();

    public void addComment(Comment comment){
        commentSet.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comment comment){
        commentSet.remove(comment);
        comment.setBook(null);
    }
}

