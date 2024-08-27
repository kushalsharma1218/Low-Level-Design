package org.example.behavioural.strategy.code.algos;

import org.example.behavioural.strategy.code.PathCalculator;

public class CarPathFiner implements PathCalculator {
    private static CarPathFiner carPathFiner;
    @Override
    public String findPath(String from, String to) {
        return "Car Path Finder";
    }

    private CarPathFiner(){}

    public static CarPathFiner getInstance(){
        if(carPathFiner == null){
            synchronized (CarPathFiner.class){
                if(carPathFiner == null){
                    carPathFiner = new CarPathFiner();
                }
            }
        }

        return carPathFiner;
    }
}
