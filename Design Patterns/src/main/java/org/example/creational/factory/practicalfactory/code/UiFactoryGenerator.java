package org.example.creational.factory.practicalfactory.code;

public class UiFactoryGenerator {

    /** but it stills seems like its violating OCP principle
     * But it's not
     * If multiple ifs or switch cases are part of your loigc then it doesn't violate OCP
     * */
    public static UIFactory generateUIFactory(PlatformEnum platform){
        return switch (platform){
            case ANDROID -> new AndroidUIFactory();
            case IOS ->  new IosUIFactory();
        };
    }
}
