package ru.otus.springcourse02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.springcourse02.domain.Person;
import ru.otus.springcourse02.service.PersonService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( Main.class );

        PersonService personService = context.getBean("personService", PersonService.class);
        Person person = personService.getByName("Roman");
        System.out.println("Name: " + person.getName() + " and age: " + person.getAge());

        context.close();

    }
}
