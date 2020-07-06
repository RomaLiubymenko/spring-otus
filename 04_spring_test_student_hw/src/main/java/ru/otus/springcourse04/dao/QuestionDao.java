package ru.otus.springcourse04.dao;

import ru.otus.springcourse04.domain.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface QuestionDao {

    ArrayList<Question> readFile() throws IOException;
}
