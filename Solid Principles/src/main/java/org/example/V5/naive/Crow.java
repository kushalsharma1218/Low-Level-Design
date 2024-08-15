package org.example.V5.naive;

import org.example.V5.naive.interfaces.Flyable;

public class Crow extends Bird implements Flyable {

    // Crow class directly dependent on SparrowCrowFlyableBehavior class
    SparrowCrowFlyableBehavior behavior = new SparrowCrowFlyableBehavior();

    @Override
    void eat() {

    }

    public void fly() {
        behavior.fly();
    }
}
