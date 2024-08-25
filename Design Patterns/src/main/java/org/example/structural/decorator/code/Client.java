package org.example.structural.decorator.code;

import org.example.structural.decorator.code.addons.BlackCurrentTopping;
import org.example.structural.decorator.code.addons.ChocolateSyrup;
import org.example.structural.decorator.code.addons.MangoTopping;
import org.example.structural.decorator.code.cones.ChocolateCone;
import org.example.structural.decorator.code.cones.OrangeCone;

public class Client {
    public static void main(String[] args) {
        IceCream iceCream =
                new BlackCurrentTopping(
                        new MangoTopping(
                                new ChocolateCone(
                                        new ChocolateSyrup(
                                                new OrangeCone()
                                        )
                                )
                        )
                );
        System.out.println(iceCream.getCost());
        System.out.println(iceCream.getDescription());
    }
}
