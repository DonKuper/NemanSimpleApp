package ru.kuper.springlearn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:my.properties")
public class AppConfig {

    @Value("${some}")
    public String configMonada;

}