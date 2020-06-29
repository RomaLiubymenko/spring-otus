package ru.otus.springcourse02.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Locale;

@Service
public class ResultTestingServiceImpl implements ResultTestingService {

    private ArrayList<Boolean> correctAnswerArrayListFlag = new ArrayList<>();
    private ArrayList<String> correctAnswerArrayList = new ArrayList<>();
    private int correctAnswerCount;
    private final MessageSource messageSource;
    private final Locale local;

    public ResultTestingServiceImpl(@Value("${application.locale}") Locale local, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.local = local;
    }


    @Override
    public void getResult() {
        System.out.println(messageSource.getMessage("resultTestingService.NUM_OF_RIGHT_ANSWER", null, local) + " " + correctAnswerCount);
        for (String correctAnswer : correctAnswerArrayList) {
            if (correctAnswer.equals("")) {
                System.out.println(messageSource.getMessage("resultTestingService.RIGHT_ANSWER", null, local));
            } else {
                System.out.println(messageSource.getMessage("resultTestingService.WRONG_ANSWER", null, local) + " " +
                        messageSource.getMessage("resultTestingService.RIGHT_ANSWER", null, local) + " -> " + correctAnswer);
            }
        }
    }

    @Override
    public void checkAnswer(String correctAnswer, String answerStudent) {
        boolean temp = correctAnswer.trim().equalsIgnoreCase(answerStudent.trim());
        correctAnswerArrayListFlag.add(temp);
        if (!temp) {
            correctAnswerArrayList.add(correctAnswer);
        } else {
            correctAnswerArrayList.add("");
            correctAnswerCount++;
        }
    }
}