package ru.otus.springcourse07.service;

import ru.otus.springcourse07.domain.Comment;

import java.util.List;

public interface CommentsService {

    void insertComment(Comment comment);
    List<Comment> outputListOfComment();
    List<Comment> getCommentsByBookTitle(String title);
    Comment getCommentById(int id);

}
