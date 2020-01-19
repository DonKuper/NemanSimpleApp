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
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.model.Buyer;
import ru.kuper.springlearn.repo.BookRepository;
import ru.kuper.springlearn.repo.BuyerRepoJDBC;
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

        //SpringJDBC test
    /*
        BuyerRepoJDBC buyerRepoJDBC = ctx.getBean(BuyerRepoJDBC.class);
        buyerRepoJDBC.save(new Buyer(1L,"Dima","Russia",1000));
        buyerRepoJDBC.save(new Buyer(2L,"Dimas","Ukraine",2000));
        System.out.println("-----all---");
        buyerRepoJDBC.findAll().forEach(System.out::println);
        System.out.println("-----by id---");
        System.out.println(buyerRepoJDBC.findById("1").toString());
*/
    }


//    @Bean
//    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
//        return args -> {
//            System.out.println("Some spring's beans: ");
//            Arrays.stream(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);
//        };
//    }

    @Bean
    public CommandLineRunner preload(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("java", "Gosling"));
            bookRepository.save(new Book("elexir", "valim"));
            bookRepository.save(new Book("scala", "odersky"));
            bookRepository.save(new Book("clojure", "hitch"));
        };
    }


}
