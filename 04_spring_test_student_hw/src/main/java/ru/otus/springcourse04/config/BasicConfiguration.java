package ru.otus.springcourse04.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;


@ConfigurationProperties(prefix = "application")
public class BasicConfiguration {

    private String path;
    private Locale locale;

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/i18n/bundle");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
