package ru.otus.springcourse03.dao;

import ru.otus.springcourse03.domain.Question;

import java.io.IOException;
import java.util.ArrayList;

public interface QuestionDao {

    ArrayList<Question> readFile() throws IOException;
}
