package ru.otus.springcource01.service;

import ru.otus.springcource01.dao.QuestionDao;
import ru.otus.springcource01.domain.Question;
import ru.otus.springcource01.domain.Student;
import ru.otus.springcource01.service.exceptionservice.ExceptionServiceConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class StartTestingServiceImpl implements StartTestingService {


    private static final String WELCOME = "Приветствую на тестировании";
    private static final String ENTER_FIRSTNAME = "Введите своё имя:";
    private static final String ENTER_LASTNAME = "Введите свою фамилию:";
    private static final String ENTER_ANSWER = "Введите ответ:";
    private static final String QUESTION_MARK = "?";
    private static final String END_TESTING = "тестирование завершено. Ваш результат:";

    private QuestionDao questionDao;
    private ResultTestingService resultTestingService;
    private Student student;

    public StartTestingServiceImpl(QuestionDao questionDao, ResultTestingService resultTestingService) {
        this.questionDao = questionDao;
        this.resultTestingService = resultTestingService;
    }

    @Override
    public void startTesting() throws Exception{
        ArrayList<Question> questionArrayList = questionDao.readFile();
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            getFullName(bufferedReader);
            for (Question question : questionArrayList) {
                System.out.println(question.getQuestion() + QUESTION_MARK);
                System.out.println(ENTER_ANSWER);
                resultTestingService.checkAnswer(question.getAnswer(), getAnswerFromStudent(bufferedReader));
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(student.getFirstname() + " " + student.getLastname() + " " + END_TESTING);
        resultTestingService.getResult();
    }

    @Override
    public void getFullName(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(WELCOME);
        System.out.println(ENTER_FIRSTNAME);
        String firstname = getAnswerFromStudent(bufferedReader);
        System.out.println(ENTER_LASTNAME);
        String lastname = getAnswerFromStudent(bufferedReader);
        student = new Student(firstname, lastname);
    }

    @Override
    public String getAnswerFromStudent(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException {
        try {
            String line = bufferedReader.readLine();
            if(line.isEmpty()){
                throw new ExceptionServiceConsole("Ошибка ввода данных. Проверьте правильность ввода");
            }
            return line;
        }
        catch (IOException exception){
            throw new IOException("Ошибка при считывании с потока данных");
        }
        catch (Exception exception){
            throw new ExceptionServiceConsole(exception.getMessage());
        }
    }
}

