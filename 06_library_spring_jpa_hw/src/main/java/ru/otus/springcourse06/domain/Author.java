package ru.otus.springcourse06.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Authors")
public class Author {

    @Id
    @Column(name = "idAuthor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;

    @Column(nullable = false, length = 70)
    private String firstname;

    @Column(nullable = false, length = 70)
    private String lastname;

    @Column(nullable = false, length = 100)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "author")
    @ToString.Exclude
    private List<Book> bookList;

    @Override
    public String toString(){
        return String.valueOf(this.getIdAuthor());
    }

}

