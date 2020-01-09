package ru.kuper.springlearn.model.auto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Owner {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded //Необязательная аннотация, т.к. используем Embeddable
    private Address address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Car> cars = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "owner_gym", joinColumns = @JoinColumn(name = "owner_id"), inverseJoinColumns = @JoinColumn(name = "gym_id"))
    private List<Gym> gyms = new ArrayList<>();

}