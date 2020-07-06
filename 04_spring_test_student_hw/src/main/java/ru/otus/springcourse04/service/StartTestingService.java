package ru.otus.springcourse04.service;

import ru.otus.springcourse04.domain.Student;

public interface StartTestingService {

    void startTesting();
    void getFullName(String firstname, String lastname);
    Student getStudent();
}