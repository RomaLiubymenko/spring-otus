package ru.otus.springcourse09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse09.model.Genre;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
