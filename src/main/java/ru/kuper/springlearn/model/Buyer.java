package ru.kuper.springlearn.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Setter @Getter @ToString
public class Buyer {

    private Long id;

    private String name;

    private String countiry;

    private Integer token;

    public Buyer(Long id, String name, String countiry, Integer token) {
        this.id = id;
        this.name = name;
        this.countiry = countiry;
        this.token = token;
    }


}
