package ru.otus.springcourse04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestStudentsSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(TestStudentsSpringBootApplication.class, args);
		ConfigurationPropertiesClass propertiesClass = run.getBean(ConfigurationPropertiesClass.class);
		System.out.println(propertiesClass.getVersion());

	}

}
