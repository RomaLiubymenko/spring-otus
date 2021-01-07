package ru.otus.springcourse10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse10.model.Author;

@Repository
public interface AuthorsRepository extends JpaRepository<Author, Integer> {
}
