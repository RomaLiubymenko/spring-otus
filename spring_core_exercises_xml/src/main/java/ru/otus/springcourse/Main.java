package ru.otus.springcourse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springcourse.domain.Person;
import ru.otus.springcourse.service.PersonService;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        PersonService personService = context.getBean("personServiceBean", PersonService.class);
        Person person = personService.getByName("Roman");
        System.out.println("Name: " + person.getName() + " and age: " + person.getAge());

        context.close();

    }
}
