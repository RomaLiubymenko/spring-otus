package ru.otus.springcourse09.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Integer id;
    private BookDto bookDto;
    private String text;
    private String publicationTime;
}
