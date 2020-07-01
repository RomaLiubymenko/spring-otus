package ru.otus.springcourse02.dao;

import ru.otus.springcourse02.domain.Question;
import java.util.ArrayList;

public interface QuestionDao {

    ArrayList<Question> readFile() throws Exception;
}
