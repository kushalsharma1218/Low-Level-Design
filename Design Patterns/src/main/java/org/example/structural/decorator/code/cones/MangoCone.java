package org.example.structural.decorator.code.cones;

import org.example.structural.decorator.code.IceCream;

public class MangoCone implements IceCream {
    IceCream iceCream;

    /** Use this constructor if starting with this cone */
    public MangoCone(){}

    /** Use this constructor if these already a cone in ice cream */
    public MangoCone(IceCream iceCream){
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
            return "MangoCone";
        }
        return "MangoCone" + this.iceCream.getDescription();
    }
}
