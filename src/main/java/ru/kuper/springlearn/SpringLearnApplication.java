package ru.kuper.springlearn;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import outside.Clojure;
import ru.kuper.springlearn.service.CatSound;
import ru.kuper.springlearn.service.Csharp;
import ru.kuper.springlearn.service.Scala;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"outside","ru.kuper.springlearn"})
@ImportResource("classpath:app-config.xml")
public class SpringLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =SpringApplication.run(SpringLearnApplication.class, args);
      //  CatSound catSound =(CatSound)ctx.getBean("catSound");
      //  System.out.println(catSound.sound());
        Clojure clojure = (Clojure) ctx.getBean("clojure");
        System.out.println(clojure.learnMe());
        Scala scala = (Scala) ctx.getBean("scala");
        System.out.println(scala.learnMe());
        Csharp csharp = (Csharp) ctx.getBean("csharp");
        System.out.println(csharp.learnMe());
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
//        return args -> {
//            System.out.println("Some spring's beans: ");
//            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
//        };
//    }

}
