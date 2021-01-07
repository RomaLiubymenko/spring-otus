package ru.otus.springcourse10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse10.model.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBook_Title(String title);
}
