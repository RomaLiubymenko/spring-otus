package ru.otus.springcourse09.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Authors")
@EqualsAndHashCode(of = {"idAuthor"})
public class Author {

    private String name;

    @Id
    @Column(name = "idAuthor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAuthor;

    @Column(nullable = false, length = 70)
    private String firstname;

    @Column(nullable = false, length = 70)
    private String lastname;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "author", orphanRemoval = true)
    @ToString.Exclude
    private Set<Book> bookSet =  new HashSet<>();

    public Author() {
    }

    public void addBook(Book book){
        bookSet.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book){
        bookSet.remove(book);
        book.setAuthor(null);
    }

}

