package ru.otus.springcourse04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.springcourse04.config.BasicConfiguration;


@SpringBootApplication
@EnableConfigurationProperties(BasicConfiguration.class)
public class TestStudentsSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestStudentsSpringBootApplication.class, args);
    }
}
