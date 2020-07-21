package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse07.domain.Genre;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
