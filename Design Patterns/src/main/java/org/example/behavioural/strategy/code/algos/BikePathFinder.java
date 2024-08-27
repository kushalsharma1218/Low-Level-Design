package org.example.behavioural.strategy.code.algos;

import org.example.behavioural.strategy.code.PathCalculator;

public class BikePathFinder implements PathCalculator {
    private static BikePathFinder bikePathFinder;
    @Override
    public String findPath(String from, String to) {
        return "Bike Path Finder";
    }

    private BikePathFinder(){}

    public static BikePathFinder getInstance(){
        if(bikePathFinder == null){
            synchronized (BikePathFinder.class){
                if(bikePathFinder == null){
                    bikePathFinder = new BikePathFinder();
                }
            }
        }

        return bikePathFinder;
    }
}
