package ru.otus.springcourse02.dao;

import ru.otus.springcourse02.domain.Person;

public interface PersonDao {
    Person findByName(String name);
}
