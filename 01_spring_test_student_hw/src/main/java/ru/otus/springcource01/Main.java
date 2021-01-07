package ru.otus.springcource01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springcource01.service.StartTestingService;

public class Main {

    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StartTestingService startTestingService = context.getBean("startTestingServiceBean", StartTestingService.class);
        startTestingService.startTesting();
        context.close();
    }
}
