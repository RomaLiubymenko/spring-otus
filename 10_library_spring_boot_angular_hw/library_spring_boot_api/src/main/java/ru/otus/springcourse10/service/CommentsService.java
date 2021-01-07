package ru.otus.springcourse10.service;

import ru.otus.springcourse10.dto.CommentDto;

import java.util.List;

public interface CommentsService {

    void insertCommentDto(CommentDto commentDto);
    List<CommentDto> outputListOfCommentDto();
    List<CommentDto> getCommentDtosByBookTitle(String title);
    CommentDto getCommentDtoById(int id);

}
