package ru.otus.springcource01.service;


import java.util.ArrayList;

public class ResultTestingServiceImpl implements ResultTestingService {

    private static final String NUM_OF_RIGHT_ANSWER = "Количество правильных ответов:";
    private final String RIGHT_ANSWER = "Правильный ответ";
    private static final String WRONG_ANSWER = "Ответ не правильный. ";

    private ArrayList<Boolean> correctAnswerArrayListFlag = new ArrayList<>();
    private ArrayList<String> correctAnswerArrayList = new ArrayList<>();
    private int correctAnswerCount;

    @Override
    public void getResult() {
        System.out.println(NUM_OF_RIGHT_ANSWER + " " + correctAnswerCount);
        for (String correctAnswer : correctAnswerArrayList) {
            if (correctAnswer.equals("")) {
                System.out.println(RIGHT_ANSWER);
            } else {
                System.out.println(WRONG_ANSWER + " " + RIGHT_ANSWER + " -> " + correctAnswer);
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
