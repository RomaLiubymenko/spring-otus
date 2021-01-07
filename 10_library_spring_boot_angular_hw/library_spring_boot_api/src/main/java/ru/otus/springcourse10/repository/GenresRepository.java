package ru.otus.springcourse10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse10.model.Genre;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
