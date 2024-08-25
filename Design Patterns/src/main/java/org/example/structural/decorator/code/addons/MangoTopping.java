package org.example.structural.decorator.code.addons;

import org.example.structural.decorator.code.IceCream;

public class MangoTopping implements IceCream {
    IceCream iceCream;

    /** No default constructor, you cant select addons without a cone */
    public MangoTopping(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public double getCost() {
        return 10 + this.iceCream.getCost();
    }

    @Override
    public String getDescription() {
        return "MangoTopping"+ this.iceCream.getDescription();
    }

}
