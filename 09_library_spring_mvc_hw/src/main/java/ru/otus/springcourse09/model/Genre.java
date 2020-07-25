package ru.otus.springcourse09.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genres")
@EqualsAndHashCode(of = {"idGenre"})
public class Genre {

    @Id
    @Column(name = "idGenre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenre;

    @Column(name = "nameGenre", length = 50)
    private String nameGenre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre", fetch = FetchType.EAGER, orphanRemoval = true)
    @ToString.Exclude
    private Set<Book> bookSet = new HashSet<>();

    public void addBook(Book book){
        bookSet.add(book);
        book.setGenre(this);
    }

    public void removeBook(Book book){
        bookSet.remove(book);
        book.setGenre(null);
    }

}