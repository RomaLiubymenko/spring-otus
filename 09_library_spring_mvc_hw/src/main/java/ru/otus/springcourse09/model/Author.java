package ru.otus.springcourse09.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Authors")
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
    private Set<Book> bookSet = new HashSet<>();


    public void addBook(Book book) {
        bookSet.add(book);
        book.setAuthor(this);
    }

    public void removeBook(Book book) {
        bookSet.remove(book);
        book.setAuthor(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
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

    public Set<ru.otus.springcourse09.model.Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<ru.otus.springcourse09.model.Book> bookSet) {
        this.bookSet = bookSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(idAuthor, author.idAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAuthor);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", idAuthor=" + idAuthor +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", country='" + country + '\'' +
                ", bookSet=" + bookSet +
                '}';
    }
}

