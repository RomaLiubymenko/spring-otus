package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse07.domain.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Integer> {
}
