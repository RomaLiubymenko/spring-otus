package ru.otus.springcourse07.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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
    private List<Book> bookList;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        Author author = (Author) o;
        return idAuthor == author.idAuthor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor);
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
