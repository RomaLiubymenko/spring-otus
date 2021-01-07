package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse07.domain.Genre;

@Repository
public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
