package org.example.structural.decorator.code.cones;

import org.example.structural.decorator.code.IceCream;

public class ChocolateCone implements IceCream {
    IceCream iceCream;

    /** Use this constructor if starting with this cone */
    public ChocolateCone(){}

    /** Use this constructor if these already a cone in ice cream */
    public ChocolateCone(IceCream iceCream){
        this.iceCream = iceCream;
    }
    @Override
    public double getCost() {
        if(this.iceCream == null){
            return 20;
        }
        return 20 + this.iceCream.getCost();
    }

    @Override
    public String getDescription() {
        if(this.iceCream == null){
            return "ChocolateCone";
        }
        return "ChocolateCone" + this.iceCream.getDescription();
    }
}
