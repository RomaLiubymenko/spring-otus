package ru.otus.springcourse02.service;

import ru.otus.springcourse02.service.exceptionservice.ExceptionServiceConsole;

import java.io.BufferedReader;
import java.io.IOException;

public interface StartTestingService {

    void startTesting() throws Exception;
    void getFullName(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException;
    String getAnswerFromStudent(BufferedReader bufferedReader) throws ExceptionServiceConsole, IOException;

}