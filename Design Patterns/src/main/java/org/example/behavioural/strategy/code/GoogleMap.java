package org.example.behavioural.strategy.code;

public class GoogleMap {
    PathCalculator pathCalculator;

    public static void main(String[] args) {
        GoogleMap googleMap = new GoogleMap();
        System.out.println(googleMap.findPath("from", "to", "mm"));
    }
    String findPath(String from, String to, String mode) {
        // instead lot of if else that violated srp and ocp
        pathCalculator = PathCalculatorFactory.getPathCalculator(mode);
        return pathCalculator.findPath(from, to);
    }
}
