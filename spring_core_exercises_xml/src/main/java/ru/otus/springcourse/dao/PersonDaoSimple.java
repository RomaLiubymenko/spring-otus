package ru.otus.springcourse.dao;

import ru.otus.springcourse.domain.Person;

public class PersonDaoSimple implements PersonDao {

    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public Person findByName(String name) {
        return new Person(name, age);
    }
}
