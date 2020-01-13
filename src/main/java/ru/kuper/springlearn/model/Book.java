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
    @Size(min = 5, message = "must be min 5 characters!")
    private String name;
    @Size(min = 7, message = "must be min 7 characters!")
    private String author;



}
