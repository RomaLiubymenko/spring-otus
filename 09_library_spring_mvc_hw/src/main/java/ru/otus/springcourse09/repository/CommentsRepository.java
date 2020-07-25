package ru.otus.springcourse09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse09.model.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBook_Title(String title);
}
