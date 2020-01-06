package ru.kuper.springlearn.service;

import org.springframework.stereotype.Service;

@Service
public class HorseSound implements SoundAnimals {

    @Override
    public String sound() {
        return "neigh";
    }
}
