package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse07.domain.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBook_Title(String title);
}
