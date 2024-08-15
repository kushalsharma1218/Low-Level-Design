package org.example.V1;

public class Bird {
    private Double weight;
    private String colour;
    private String type;
    private Double size;
    private String walkType;

    public void fly(){
        if(type.equals("SPARROW")){
            // impl of sparrow flying
            System.out.println("Flying bird is sparrow");
        }
        if(type.equals("CROW")){
            // impl for crow fly
            System.out.println("Flying bird is Crow");
        }
        // ...... other birds
    }
    public void eat(){}
    public void makeSound(){}
}
