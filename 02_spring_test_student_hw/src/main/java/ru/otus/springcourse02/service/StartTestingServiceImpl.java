package ru.otus.springcourse02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springcourse02.dao.QuestionDao;
import ru.otus.springcourse02.domain.Question;
import ru.otus.springcourse02.domain.Student;
import ru.otus.springcourse02.service.exceptionservice.ExceptionServiceConsole;

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
            @Qualifier("questionDaoImpl") QuestionDao questionDao,
            @Qualifier("resultTestingServiceImpl") ResultTestingService resultTestingService,
            @Value("${application.locale}") Locale locale,
            MessageSource messageSource

    ) {
        this.questionDao = questionDao;
        this.resultTestingService = resultTestingService;
        this.locale = locale;
        this.messageSource = messageSource;
    }

    @Override
    public void startTesting() throws Exception {
        ArrayList<Question> questionArrayList = questionDao.readFile();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            getFullName(bufferedReader);
            for (Question question : questionArrayList) {
                System.out.println(question.getQuestion() + QUESTION_MARK);
                System.out.println(messageSource.getMessage("startTestingService.ENTER_ANSWER",null,locale));
                resultTestingService.checkAnswer(question.getAnswer(), getAnswerFromStudent(bufferedReader));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(student.getFirstname() + " " + student.getLastname() +
                messageSource.getMessage("startTestingService.END_TESTING",null,locale));
        resultTestingService.getResult();
    }

    @Override
    public void getFullName(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(messageSource.getMessage("startTestingService.WELCOME",null,locale));
        System.out.println(messageSource.getMessage("startTestingService.ENTER_FIRSTNAME",null,locale));
        String firstname = getAnswerFromStudent(bufferedReader);
        System.out.println(messageSource.getMessage("startTestingService.ENTER_LASTNAME",null,locale));
        String lastname = getAnswerFromStudent(bufferedReader);
        student = new Student(firstname, lastname);
    }

    @Override
    public String getAnswerFromStudent(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException {
        try {
            String line = bufferedReader.readLine();
            if (line.isEmpty()) {
                throw new ExceptionServiceConsole(messageSource.getMessage("startTestingService.INPUT_ERROR",null,locale));
            }
            return line;
        } catch (IOException exception) {
            throw new IOException(messageSource.getMessage("startTestingService.IOException",null,locale));
        } catch (Exception exception) {
            throw new ExceptionServiceConsole(exception.getMessage());
        }
    }
}