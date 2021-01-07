package ru.otus.springcourse07.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


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
    private List<Book> bookList;

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
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
        Genre genre = (Genre) o;
        return idGenre == genre.idGenre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGenre);
    }

    @Override
    public String toString() {
        return "Genre{" +
                "idGenre=" + idGenre +
                ", nameGenre='" + nameGenre + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
