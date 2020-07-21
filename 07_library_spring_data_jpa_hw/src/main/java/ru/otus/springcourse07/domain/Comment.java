package ru.otus.springcourse07.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comments")
public class Comment {

    @Id
    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComment;

    @ManyToOne
    @JoinColumn(name = "idBook", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String text;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime publicationTime;



}
