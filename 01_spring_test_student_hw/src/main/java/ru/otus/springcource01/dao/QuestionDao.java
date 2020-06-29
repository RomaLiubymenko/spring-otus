package ru.otus.springcource01.dao;

import ru.otus.springcource01.domain.Question;
import java.util.ArrayList;

public interface QuestionDao {

    ArrayList<Question> readFile() throws Exception;
}
