package ru.otus.springcourse03.service;

import java.io.BufferedReader;

public interface StartTestingService {

    void startTesting();
    String getAnswerFromStudent(BufferedReader bufferedReader) throws Exception;

}