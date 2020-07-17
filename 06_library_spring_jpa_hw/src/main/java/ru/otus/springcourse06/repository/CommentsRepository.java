package ru.otus.springcourse06.repository;

import ru.otus.springcourse06.domain.Comment;

import java.util.List;

public interface CommentsRepository {

    void insert(Comment author);
    List<Comment> getAll();
    Comment getById(int id);

}
