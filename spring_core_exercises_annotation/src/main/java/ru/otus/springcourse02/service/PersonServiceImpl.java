package ru.otus.springcourse02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springcourse02.dao.PersonDao;
import ru.otus.springcourse02.domain.Person;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getByName(String name) {
        return personDao.findByName(name);
    }

}
