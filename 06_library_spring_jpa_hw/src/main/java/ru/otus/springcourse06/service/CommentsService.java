package ru.otus.springcourse06.service;

import ru.otus.springcourse06.domain.Comment;

import java.util.List;

public interface CommentsService {

    void insertComment(Comment comment);
    List<Comment> outputListOfComment();
    Comment getCommentById(int id);

}
