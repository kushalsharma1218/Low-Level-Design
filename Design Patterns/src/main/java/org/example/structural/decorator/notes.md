# Decorator Design Pattern


## Definition

>If we have any entity to which we want to change behaviours or add new behaviours, 

>Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.


## When to use
- If we have to scenario, where we add property or a new feature, to a base entity at runtime, where final output depends on output of base
You should use decorator pattern.
- You need to add different combinations of features or behaviors to objects. 
  Decorators can be stacked in different ways to create these combinations.


In lot of UI codes, decorator pattern is used
Examples
- HTML, we add css to decorate or Buttons and other html elements, HTML element act as a Base here
- SpringBoot.run(), we add layers to our spring app, like add security layer, web layer
- Ice cream
- Coffee machine
- Pizza bending machine



## Problem statement

You need to build an application that take orders of cone ice cream.
Lets say you want a ice cream cone, first you select a type of cone, inside that you want a scoop of black current and add a scoop of mango, and a scoop of orange

1. Build a ice cream
2. Cost of ice cream
3. Description of ice cream ingredients

We can select multiple cones in one ice cream


## Solution
We can do something like this

```java
interface Cone{ 
    double getCost();
    String getDescription();
}
class OrangeCone implements Cone {
    double getCost(){ }
    String getDescription(){ }
}
class MangoCone implements Cone {
    double getCost(){ }
    String getDescription(){ }
}
// more type of cone

interface Toppings{
    double getCost();
    String getDescription();
}
class MangoTopping implements Topping{
    double getCost(){ }
    String getDescription(){ }
}
class ChoclateTopping implements Topping{
    double getCost(){ }
    String getDescription(){ }
}
// more type of topping

class IceCream{
    List<Cone> cone;
    List<Toppings> toppings;
    
    double getCost(){ 
        // iterate all cones and toppings to getCost
    }
    String getDescription(){
        // iterate all cones and toppings to getDescription
    }
}
```


This design looks cool...but
- With the current design we can have ice cream without cone and get billed

### Problem Statement Part 2
Now, lets say I want chocolate syrup between cones. 
- User should be able to order single cone and multiple toppings
- User should be able select multiple flavoured cone and optional to choose syrup in between cones

> **_NOTE:_**  Chocolate syrup is also a kind of topping



### Solution Part 2
Our current solution is based on separation of cone and topping, **We should count layer by layer not by cone and topping.**
We should consider Cone and topping as ingredients.



```java
interface Ingredients{ 
    double getCost();
    String getDescription();
}
class OrangeCone implements Ingredients {
    double getCost(){ }
    String getDescription(){ }
}
class MangoCone implements Ingredients {
    double getCost(){ }
    String getDescription(){ }
}
// more type of cone

class MangoTopping implements Ingredients{
    double getCost(){ }
    String getDescription(){ }
}
class ChocolateSyrup implements Ingredients{
    double getCost(){ }
    String getDescription(){ }
}
// more type of topping

class IceCream{
    List<Ingredients> ingredients;
    
    void addIngredients(Ingredients ingredient){ }
    
    double getCost(){ 
        // iterate all ingredients to getCost
    }
    String getDescription(){
        // iterate all ingredients to getDescription
    }
}
```

But this still have problems, like we can have ice cream without cone


### Decorator design pattern

Observations
- Right from the beginning, we know I have a ice cream cone as the base ingredient
- When ever we are adding something new the cost also gets added

Implementation

1. Define a interface/abstract class that represents the thing that we are trying to construct.
    ```java
    interface IceCream{
        double getCost();
        String getDescription();
    }
    ```
2. There are two kinds of ingredients we have
   - Cone, a base ingredient and itself can be considered a ice cream
   - Topping are add-ons
   
   We can divide ingredients based on this, 
   - Category base -> OrangeBase, MangoBase, ChocolateBase
   - AddOns -> OrangeAddOn, MangoAddOn, ChocolateAddOn, BerriesAddOn
   
3. For all ingredients, implement IceCream Interface
    ```java
    interface IceCream{
        double getCost();
        String getDescription();
    }
    class OrangeBase implements IceCream { }
    class MangoBase implements IceCream { }
    class ChocolateBase implements IceCream { }
    class OrangeAddOn implements IceCream { }
    class MangoAddOn implements IceCream { }
    class ChocolateAddOn implements IceCream { }
    class BerriesAddOn implements IceCream { }
    ```
   


**Final Solution**
```java
interface IceCream {
   double getCost();
   String getDescription();
}

class OrangeBase implements IceCream {
    public OrangeBase(){}
    public OrangeBase(IceCreame ic){
        this.ic = ic;
    }

   double getCost() {
        if(ic == null){
            return "1";
        }
        return 1 + ic.getCost();
   }
    String getDescription() {}
}

class MangoBase implements IceCream {
   double getCost() {}
   String getDescription() {}
}
class ChocolateBase implements IceCream {
   double getCost() {}
   String getDescription() {}
}

class OrangeAddOn implements IceCream {
   IceCreame ic;
   
   public OrangeAddOn(IceCreame ic){
       this.ic = ic;
   }
   double getCost() {}
   String getDescription() {}
}

class MangoAddOn implements IceCream {
   IceCreame ic;

   public MangoAddOn(IceCreame ic){
      this.ic = ic;
   }
   double getCost() {}
   String getDescription() {}
}

// chocolate syrup
class ChocolateSyrup implements IceCream {
   IceCreame ic;

   public ChocolateAddOn(IceCreame ic){
      this.ic = ic;
   }
   double getCost() {}
   String getDescription() {}
}

class BerriesAddOn implements IceCream {
   IceCreame ic;

   public BerriesAddOn(IceCreame ic){
      this.ic = ic;
   }
   double getCost() {}
   String getDescription() {}
}

class Client{
   public static void main(String[] args) {
      IceCream iceCream = new BerriesAddOn(new MangoAddOn(new ChocolateBase(new ChocolateSyrup(new OrangeBase()))));
      iceCream.getCost();
      iceCream.getDescription();
   }
}
```


- We don't have to traverse again and again for cost once and then description once again
- AddOna will not have default constructor so that we cant have addons without cone
- Base have two constructor such that we can have cone independently and can add multiple cone in one ice cream.


> If a class is both base and a addon it will have two constructor
> - 1 Empty constructor, when its acting as a base
> - 2 Constructor which takes a parameter of interface



