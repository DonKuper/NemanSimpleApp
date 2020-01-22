package ru.kuper.springlearn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import ru.kuper.springlearn.model.Book;
import ru.kuper.springlearn.repo.BookRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.kuper.springlearn"})
@ImportResource("classpath:app-config.xml")
public class SpringLearnApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringLearnApplication.class, args);

    }

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
