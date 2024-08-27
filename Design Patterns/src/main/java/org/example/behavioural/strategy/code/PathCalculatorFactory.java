package org.example.behavioural.strategy.code;

import org.example.behavioural.strategy.code.algos.BikePathFinder;
import org.example.behavioural.strategy.code.algos.CarPathFiner;
import org.example.behavioural.strategy.code.algos.WalkPathFInder;

public class PathCalculatorFactory {

    public static PathCalculator getPathCalculator(String mode) {
        switch (mode) {
            case "walk" -> {
                return WalkPathFInder.getInstance();
            }
            case "car" -> {
                return CarPathFiner.getInstance();
            }
            case "bike" -> {
                return BikePathFinder.getInstance();
            }

            default -> {
                return null;
            }
            // more cases
        }
    }}
