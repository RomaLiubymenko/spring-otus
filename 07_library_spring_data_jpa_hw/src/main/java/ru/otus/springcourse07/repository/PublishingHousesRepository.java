package ru.otus.springcourse07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.springcourse07.domain.PublishingHouse;

@Repository
public interface PublishingHousesRepository extends JpaRepository<PublishingHouse, Integer> {
}
