package ru.otus.springcourse04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springcourse04.config.BasicConfiguration;
import ru.otus.springcourse04.dao.QuestionDao;
import ru.otus.springcourse04.domain.Question;
import ru.otus.springcourse04.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class StartTestingServiceImpl implements StartTestingService {

    private static final String QUESTION_MARK = "?";

    private final QuestionDao questionDao;
    private final ResultTestingService resultTestingService;
    private final Locale locale;
    private final MessageSource messageSource;
    private Student student;

    @Autowired
    public StartTestingServiceImpl(
            QuestionDao questionDao,
            ResultTestingService resultTestingService,
            BasicConfiguration basicConfiguration,
            MessageSource messageSource
    ) {
        this.questionDao = questionDao;
        this.resultTestingService = resultTestingService;
        this.locale = basicConfiguration.getLocale();
        this.messageSource = messageSource;
    }

    @Override
    public void startTesting() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<Question> questionArrayList = questionDao.readFile();
            for (Question question : questionArrayList) {
                System.out.println(question.getQuestion() + QUESTION_MARK);
                System.out.println(messageSource.getMessage("startTestingService.ENTER_ANSWER", null, locale));
                resultTestingService.checkAnswer(question.getAnswer(), getAnswerFromStudent(bufferedReader));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void getFullName(String firstname, String lastname) {
        try {
            if (firstname.isEmpty() || lastname.isEmpty()) {
                throw new Exception(messageSource.getMessage("startTestingService.INPUT_ERROR", null, locale));
            }
            student = new Student(firstname, lastname);
            System.out.println(String.format(messageSource.getMessage("startTestingService.WELCOME", null, locale), firstname, lastname));
        } catch (Exception e) {
            System.out.println(messageSource.getMessage("startTestingService.somethingWentWrong", null, locale) + e.getMessage());
        }
    }


    private String getAnswerFromStudent(BufferedReader bufferedReader) throws IOException {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IOException(messageSource.getMessage("startTestingService.somethingWentWrong", null, locale) +
                    messageSource.getMessage("startTestingService.IOException", null, locale));
        }
    }

    @Override
    public Student getStudent() {
        return student;
    }
}
