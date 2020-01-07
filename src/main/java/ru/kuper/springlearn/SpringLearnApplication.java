package ru.kuper.springlearn;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.kuper.springlearn.service.CatSound;

import java.util.Arrays;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(SpringLearnApplication.class, args);
      //  CatSound catSound =(CatSound)ctx.getBean("catSound");
      //  System.out.println(catSound.sound());
    }

    @Bean
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
        return args -> {
            System.out.println("Some spring's beans: ");
            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
        };
    }

}
