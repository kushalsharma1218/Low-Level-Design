package org.example.V5.improved;

import org.example.V5.improved.interfaces.Flyable;
import org.example.V5.improved.interfaces.FlyingBehaviour;

public class Crow extends Bird implements Flyable {

    // Now we can easily change flying behavior based on our changes
    // Loose coupling
    // We can easily provide new flying behavior which will have same contract as prev behavior so no change
    // is req in fly() method only one line of code change
    FlyingBehaviour behavior = new SparrowCrowFlyableBehavior();

    @Override
    void eat() {

    }

    public void fly() {
        behavior.makeFly();
    }
}
