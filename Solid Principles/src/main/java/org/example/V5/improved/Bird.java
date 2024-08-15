package org.example.V5.improved;


/*
Bird class will now only contain generic attributes and methods that are applicable to all birds

 */
public abstract class Bird {
    private Double weight;
    private String colour;
    private String type;
    private Double size;
    private String walkType;

    abstract void eat();
}
