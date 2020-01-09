package ru.kuper.springlearn.model.auto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private Owner owner;

    @Enumerated(EnumType.STRING)
    private CarType CarType;

}
