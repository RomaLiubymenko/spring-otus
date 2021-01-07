package ru.otus.springcourse02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.springcourse02.dao.PersonDao;
import ru.otus.springcourse02.service.PersonService;
import ru.otus.springcourse02.service.PersonServiceImpl;

@Configuration
public class PersonServiceConfig {

    @Bean
    public PersonService personService(PersonDao dao){
        return new PersonServiceImpl(dao);
    }
}
