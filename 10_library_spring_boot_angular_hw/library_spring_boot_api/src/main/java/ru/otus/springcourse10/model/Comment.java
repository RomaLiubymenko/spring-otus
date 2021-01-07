package ru.otus.springcourse10.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comments")
@EqualsAndHashCode(of = {"idComment"})
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



}
