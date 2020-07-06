package ru.otus.springcourse04.service;

import ru.otus.springcourse04.domain.Student;

public interface ResultTestingService {

    void getResult(Student student);
    void checkAnswer(String correctAnswer, String answerStudent);
    void clearResultOfTheStudent(Student student);

}
