package ru.otus.springcourse09.service;

import ru.otus.springcourse09.model.Comment;

import java.util.List;

public interface CommentsService {

    void insertComment(Comment comment);
    List<Comment> outputListOfComment();
    List<Comment> getCommentsByBookTitle(String title);
    Comment getCommentById(int id);

}
