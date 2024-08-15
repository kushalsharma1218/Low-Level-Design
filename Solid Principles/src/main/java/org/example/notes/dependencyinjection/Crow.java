package org.example.notes.dependencyinjection;


public class Crow {

    // Rather than initialising itself, let the creater of Crow class's object should provide FlyingBehaviour
    FlyingBehaviour flyingBehaviour;

    Crow(FlyingBehaviour flyingBehaviour){
        this.flyingBehaviour = flyingBehaviour;
    }

    public void fly(){
        flyingBehaviour.makeFly();
    }

    public static void main(String[] args) {
        Crow c = new Crow(new FlyingBehaviour());
        c.fly();
    }
}