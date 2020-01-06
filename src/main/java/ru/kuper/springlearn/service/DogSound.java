package ru.kuper.springlearn.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile({"dog", "default"})
public class DogSound implements SoundAnimals {

    @Override
    public String sound() {
        return "woof";
    }
}
