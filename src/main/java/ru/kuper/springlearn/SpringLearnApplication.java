package ru.kuper.springlearn;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.kuper.springlearn.service.CatSound;

@SpringBootApplication
public class SpringLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(SpringLearnApplication.class, args);
        CatSound catSound =(CatSound)ctx.getBean("catSound");
        System.out.println(catSound.sound());
    }

}
