package ru.otus.springcourse02.dao;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.otus.springcourse02.Main;
import ru.otus.springcourse02.domain.Question;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Main.class})
public class QuestionDaoImplTest {

    @Autowired
    private QuestionDaoImpl questionDao;

    @Before
    public void initClass() {
        // Вот здесь я не сильно понял, как правильно инжектить путь в конструктор и сделал так
        questionDao = new QuestionDaoImpl("src/test/resources/questionsTest_en.csv");
    }

    @Test
    public void shouldReturnListOfQuestion() throws Exception {
        /*
         *  Описал 2 способа для сравения содержимого два Question-s
         *  1 использует метод equels() ( и hashcode() ) для сравения полей, который переопределен в Question
         *  2 использует containsInAnyOrder Matcher
         *  Еще 1 метод проверяет что в файла считалось в List два Question-s
         *
         */
        ArrayList<Question> questionList = new ArrayList<>(Arrays.asList(
                new Question("question1", "answer1"),
                new Question("question2", "answer2")));
        assertThat(questionList.size(), equalTo(2));
        assertThat(questionList, containsInAnyOrder(questionDao.readFile().toArray(new Question[questionDao.readFile().size()])));
        assertThat(questionList, is(equalTo(questionDao.readFile())));
    }
}
