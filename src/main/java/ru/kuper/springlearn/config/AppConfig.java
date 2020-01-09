package ru.kuper.springlearn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import ru.kuper.springlearn.service.Csharp;

@Configuration
@PropertySource("classpath:my.properties")
public class AppConfig {

    @Value("${some}")
    public String configMonada;

    @Bean
    @Scope(value = "prototype")
    public Csharp csharp() {
        return new Csharp(configMonada);
    }

}