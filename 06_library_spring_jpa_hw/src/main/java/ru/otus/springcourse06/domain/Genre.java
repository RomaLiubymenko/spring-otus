package ru.otus.springcourse06.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Genres")
public class Genre {

    @Id
    @Column(name = "idGenre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGenre;

    @Column(name = "nameGenre", length = 50)
    private String nameGenre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre", fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Book> bookList;

    @Override
    public String toString(){
        return String.valueOf(this.getIdGenre());
    }

}