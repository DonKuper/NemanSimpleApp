package ru.kuper.springlearn.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Автоинкрементация без доп. таблиц
    private Long id;

    @NotBlank
    @Size(min = 3, message = "must be min 3 characters!")
    private String name;
    @Size(min = 3, message = "must be min 3 characters!")
    private String author;

    public Book(@NotBlank @Size(min = 3, message = "must be min 3 characters!") String name,
                @Size(min = 3, message = "must be min 3 characters!") String author) {
        this.name = name;
        this.author = author;
    }

    public Book() {
    }
}
