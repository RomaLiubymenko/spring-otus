package ru.otus.springcourse02.dao;

import org.springframework.stereotype.Repository;
import ru.otus.springcourse02.domain.Person;

@Repository
public class PersonDaoSimple implements PersonDao {

    public Person findByName(String name) {
        return new Person(name, 20);
    }
}
