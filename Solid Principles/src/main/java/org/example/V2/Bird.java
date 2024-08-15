package org.example.V2;

public abstract class Bird {
    private Double weight;
    private String colour;
    private String type;
    private Double size;
    private String walkType;

    abstract void eat();
    abstract void makeSound();
    abstract void fly();
}
