package ru.otus.springcourse02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springcourse02.dao.PersonDao;
import ru.otus.springcourse02.dao.PersonDaoSimple;


@Configuration
public class PersonDaoConfig {

    @Bean
    public PersonDao personDao(){
        return new PersonDaoSimple();
    }

}
