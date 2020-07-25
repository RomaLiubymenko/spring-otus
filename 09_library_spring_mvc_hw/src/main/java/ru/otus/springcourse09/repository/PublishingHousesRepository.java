package ru.otus.springcourse09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.springcourse09.model.PublishingHouse;

public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Integer> {
}
