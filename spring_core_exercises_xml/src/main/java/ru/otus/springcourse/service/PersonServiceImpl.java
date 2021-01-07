package ru.otus.springcourse.service;

import ru.otus.springcourse.dao.PersonDao;
import ru.otus.springcourse.domain.Person;

public class PersonServiceImpl implements PersonService {



    PersonDao dao;

    public PersonServiceImpl() {
    }

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }
}
