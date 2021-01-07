package ru.otus.springcourse02.service;

import ru.otus.springcourse02.domain.Person;

public interface PersonService {
    Person getByName(String name);
}
