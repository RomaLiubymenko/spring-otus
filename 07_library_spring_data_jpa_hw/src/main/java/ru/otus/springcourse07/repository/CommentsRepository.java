package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse07.domain.Comment;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllByBook_Title(String title);
}
