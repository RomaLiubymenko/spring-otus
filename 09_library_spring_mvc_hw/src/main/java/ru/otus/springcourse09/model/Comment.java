package ru.otus.springcourse09.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime publicationTime;

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPublicationTime() {
        return publicationTime;
    }

    public void setPublicationTime(LocalDateTime publicationTime) {
        this.publicationTime = publicationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(idComment, comment.idComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComment);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", book=" + book +
                ", text='" + text + '\'' +
                ", publicationTime=" + publicationTime +
                '}';
    }
}
