package ru.otus.springcourse02.service;

import org.springframework.stereotype.Service;
import ru.otus.springcourse02.dao.PersonDao;
import ru.otus.springcourse02.domain.Person;


public class PersonServiceImpl implements PersonService {

    PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }

}
