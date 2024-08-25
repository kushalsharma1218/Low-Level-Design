package org.example.structural.decorator.code.addons;

import org.example.structural.decorator.code.IceCream;

public class BlackCurrentTopping implements IceCream {
    IceCream iceCream;

    /** No default constructor, you cant select addons without a cone */
    public BlackCurrentTopping(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public double getCost() {
        return 10 + this.iceCream.getCost();
    }

    @Override
    public String getDescription() {
        return "BlackCurrentTopping" + this.iceCream.getDescription();
    }
}
