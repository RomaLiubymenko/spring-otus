package ru.otus.springcourse03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.springcourse03.config.BasicConfiguration;
import ru.otus.springcourse03.service.StartTestingService;

@SpringBootApplication
@EnableConfigurationProperties(BasicConfiguration.class)
public class TestStudentsSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestStudentsSpringBootApplication.class, args);
        StartTestingService startTestingService = context.getBean(StartTestingService.class);
        startTestingService.startTesting();
        context.close();
    }

}
