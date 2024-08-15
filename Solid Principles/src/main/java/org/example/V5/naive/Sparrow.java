package org.example.V5.naive;

import org.example.V5.naive.interfaces.Flyable;

public class Sparrow extends Bird implements Flyable  {

    // Sparrow class directly dependent on SparrowCrowFlyableBehavior class
    // tight coupling
    SparrowCrowFlyableBehavior behavior = new SparrowCrowFlyableBehavior();

    @Override
    void eat() {

    }


    @Override
    public void fly() {
        behavior.fly();
    }

}
