package ru.kuper.springlearn.model.auto;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String city;
    private String street;
    private String country;


}
