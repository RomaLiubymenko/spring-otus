package ru.otus.springcourse10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse10.model.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Integer> {
}
