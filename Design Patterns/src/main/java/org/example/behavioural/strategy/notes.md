# Strategy Design Pattern

## Definition
Rather than implementing behaviours in a method, implement in a separate class.
For every way to do a thing create separate class.

> Strategy is a behavioral design pattern that lets you define a family of algorithms, 
> put each of them into a separate class, and make their objects interchangeable.

>In layman’s terms, strategy pattern gives a class the ability to perform a certain task in different ways or strategies, without that class knowing the implementation details of any strategy.

>**Factory’s sole purpose is to create objects and strategy’s sole intent to is to provide a mechanism to select/run different algorithm.**

## When to use
- When there are multiple ways to do something, you often see violation of SRP and OCP principle
- Use the Strategy pattern when you want to use different variants of an algorithm within an object 
  and be able to switch from one algorithm to another during runtime.
- Use the pattern when your class has a massive conditional statement that switches between different variants of the same algorithm.



## Problem Statement
Consider of Google Map, it provides us different paths based on transport mode
```java
class GoogleMap{
    void findPath(String from, String to, String transportMode){
        if("walk".equals(transportMode)){
            // algo to find path based on walk
        }
        if("car".equals(transportMode)){
            // algo to find path based on car
        }
        if("bike".equals(transportMode)){
            // algo to find path based on bike
        }
    }
}
```

So we know that our current code violates SRP and OCP

Acc to Strategy Design Pattern create a separate class for every algo

```java
class GoogleMap{
    void findPath(String from, String to, String transportMode){
        if("walk".equals(transportMode)){
            WalkAlgo walkAlgo = new WalkAlgo();
            walkAlgo.findPath();
        }
        if("car".equals(transportMode)){
            CarAlgo carAlgo = new CarAlgo();
            carAlgo.findPath();
        }
        if("bike".equals(transportMode)){
            BikeAlgo bikeAlgo = new BikeAlgo();
            bikeAlgo.findPath();
        }
    }
}

class WalkAlgo{
    void findPath(String from, String to, String transportMode){ }
}

class CarAlgo{
    void findPath(String from, String to, String transportMode){ }
}

class BikeAlgo{
    void findPath(String from, String to, String transportMode){ }
}
```

**Problems**
- It violates Dependency Inversion principle now, we are coding to a class/impl you rather code to an interface
  
We can introduce an interface to remove DI, and use a factory to get object of PathFactory based on mode
Also do we need to create the object everytime? No right we don't want to create the object every time.
We will make Our all algo singleton. 

```java
class GoogleMap {
    PathCalculator pathCalculator;

    public GoogleMap(PathCalculator pathCalculator) {
        this.pathCalculator = pathCalculator;
    }

    void findPath(String from, String to, String mode) {
        pathCalculator = PathCalculatorFactory.getPathCalculator(mode);
        return pathCalculator.findPath(from, to);
    }
}

class PathCalculatorFactory {
    WalkAlgo walkAlgo = WalkAlgo.getInstance();
    CarAlgo carAlgo = CarAlgo.getInstance();
    BikeAlgo bikeAlgo = BikeAlgo.getInstance();

    public static PathCalculatorFactory getPathCalculator(String mode) {
        switch (mode) {
            case "walk" -> {
                return walkAlgo;
            }
            case "car" -> {
                return carAlgo;
            }
            case "bike" -> {
                return bikeAlgo;
            }
            // more cases
        }
    }
}

interface PathCalculator {
    void findPath(String from, String to);
}
//singleton classes
class WalkAlgo implements PathCalculator {
    void findPath(String from, String to) {
    }
    
    public static WalkAlgo getInstance(){
        
    }
}

class CarAlgo implements PathCalculator {
    void findPath(String from, String to) {
    }

    public static CarAlgo getInstance(){
        //...
    }
}

class BikeAlgo implements PathCalculator {
    void findPath(String from, String to) {
    }

    public static BikeAlgo getInstance(){
        //....
    }
}
```