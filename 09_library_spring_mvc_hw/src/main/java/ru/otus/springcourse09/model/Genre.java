package ru.otus.springcourse09.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Genres")
public class Genre {

    @Id
    @Column(name = "idGenre")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGenre;

    @Column(name = "nameGenre", length = 50)
    private String nameGenre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genre", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Book> bookSet = new HashSet<>();

    public void addBook(Book book) {
        bookSet.add(book);
        book.setGenre(this);
    }

    public void removeBook(Book book) {
        bookSet.remove(book);
        book.setGenre(null);
    }

    public Integer getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(Integer idGenre) {
        this.idGenre = idGenre;
    }

    public String getNameGenre() {
        return nameGenre;
    }

    public void setNameGenre(String nameGenre) {
        this.nameGenre = nameGenre;
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
        Genre genre = (Genre) o;
        return Objects.equals(idGenre, genre.idGenre);
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
                ", bookSet=" + bookSet +
                '}';
    }
}
