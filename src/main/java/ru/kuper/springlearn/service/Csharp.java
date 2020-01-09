package ru.kuper.springlearn.service;

public class Csharp {

    private String monada;

    public Csharp(String monada) {
        this.monada = monada;
    }

    public String learnMe(){
        return monada + "Hello from Csharp";
    }
}
