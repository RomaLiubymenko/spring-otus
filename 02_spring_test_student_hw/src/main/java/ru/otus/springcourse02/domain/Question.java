package ru.otus.springcourse02.domain;

import java.util.Objects;

public class Question {

    private String question;
    private String answer;

    public Question() {
    }

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question questionObj = (Question) o;
        return Objects.equals(question, questionObj.question) &&
                Objects.equals(answer, questionObj.answer);
    }

    @Override
    public int hashCode() {
        return question.hashCode() + answer.hashCode();
    }

}