package ru.otus.springcourse09.model;

import javax.persistence.*;
import java.time.LocalDate;;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Books")
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
    private Set<Comment> commentSet = new HashSet<>();

    public void addComment(Comment comment){
        commentSet.add(comment);
        comment.setBook(this);
    }

    public void removeComment(Comment comment){
        commentSet.remove(comment);
        comment.setBook(null);
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public ru.otus.springcourse09.model.Genre getGenre() {
        return genre;
    }

    public void setGenre(ru.otus.springcourse09.model.Genre genre) {
        this.genre = genre;
    }

    public ru.otus.springcourse09.model.PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(ru.otus.springcourse09.model.PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Set<ru.otus.springcourse09.model.Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<ru.otus.springcourse09.model.Comment> commentSet) {
        this.commentSet = commentSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(idBook, book.idBook);
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
                ", commentSet=" + commentSet +
                '}';
    }
}

