package ru.otus.springcourse03.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springcourse03.config.BasicConfiguration;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class ResultTestingServiceImpl implements ResultTestingService {

    private ArrayList<String> correctAnswerArrayList = new ArrayList<>();
    private int correctAnswerCount;
    private final MessageSource messageSource;
    private final Locale locale;

    @Autowired
    public ResultTestingServiceImpl(BasicConfiguration basicConfiguration, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.locale = basicConfiguration.getLocale();
    }


    @Override
    public void getResult() {
        System.out.println(messageSource.getMessage("resultTestingService.NUM_OF_RIGHT_ANSWER", null, locale) + " " + correctAnswerCount);
        for (String correctAnswer : correctAnswerArrayList ) {
            if (correctAnswer.equals("")) {
                System.out.println(messageSource.getMessage("resultTestingService.RIGHT_ANSWER", null, locale));
            } else {
                System.out.println(messageSource.getMessage(  "resultTestingService.WRONG_ANSWER", null, locale) + " " +
                        messageSource.getMessage("resultTestingService.RIGHT_ANSWER", null, locale) + " -> " + correctAnswer);
            }
        }
    }

    @Override
    public void checkAnswer(String correctAnswer, String answerStudent) {
        boolean temp = correctAnswer.trim().equalsIgnoreCase(answerStudent.trim());
        if (!temp) {
            correctAnswerArrayList.add(correctAnswer);
        } else {
            correctAnswerArrayList.add("");
            correctAnswerCount++;
        }
    }
}