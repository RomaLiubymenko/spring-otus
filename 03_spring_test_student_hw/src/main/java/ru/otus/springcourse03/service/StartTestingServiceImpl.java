package ru.otus.springcourse03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springcourse03.config.BasicConfiguration;
import ru.otus.springcourse03.dao.QuestionDao;
import ru.otus.springcourse03.domain.Question;
import ru.otus.springcourse03.domain.Student;

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
    private Student student;
    private final Locale locale;
    private final MessageSource messageSource;

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
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            ArrayList<Question> questionArrayList = questionDao.readFile();
            getFullName(bufferedReader);
            for (Question question : questionArrayList) {
                System.out.println(question.getQuestion() + QUESTION_MARK);
                System.out.println(messageSource.getMessage("startTestingService.ENTER_ANSWER", null, locale));
                resultTestingService.checkAnswer(question.getAnswer(), getAnswerFromStudent(bufferedReader));
            }
            System.out.println(student.getFirstName() + " " + student.getLastName() +
                    messageSource.getMessage("startTestingService.END_TESTING", null, locale));
            resultTestingService.getResult();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void getFullName(BufferedReader bufferedReader) throws Exception {
        System.out.println(messageSource.getMessage("startTestingService.WELCOME", null, locale));
        System.out.println(messageSource.getMessage("startTestingService.ENTER_FIRSTNAME", null, locale));
        String firstname = getAnswerFromStudent(bufferedReader);
        System.out.println(messageSource.getMessage("startTestingService.ENTER_LASTNAME", null, locale));
        String lastname = getAnswerFromStudent(bufferedReader);
        student = new Student(firstname, lastname);
    }


    public String getAnswerFromStudent(BufferedReader bufferedReader) throws Exception {
        try {
            String line = bufferedReader.readLine();
            if (line.isEmpty()) {
                throw new Exception(messageSource.getMessage("startTestingService.INPUT_ERROR", null, locale));
            }
            return line;
        } catch (IOException exception) {
            throw new IOException(messageSource.getMessage("startTestingService.IOException", null, locale));
        } catch (Exception exception) {
            throw new Exception(messageSource.getMessage("startTestingService.somethingWentWrong", null, locale) + exception.getMessage());
        }
    }
}