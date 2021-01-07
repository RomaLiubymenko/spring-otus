package ru.otus.springcourse06.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

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
    private List<Comment> commentList;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return idBook == book.idBook;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBook);
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", author=" + author +
                ", genre=" + genre +
                ", publishingHouse=" + publishingHouse +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberOfPages=" + numberOfPages +
                ", commentList=" + commentList +
                '}';
    }
}

