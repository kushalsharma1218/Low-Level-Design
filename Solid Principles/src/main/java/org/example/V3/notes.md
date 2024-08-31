# LSP (Liskov substitution principle)

> Object of child class as-is substitutable in a variable of parent type, without requiring any code change

> In simpler terms, if code is written to work with a specific type of object (the base class), 
> it should also be able to work seamlessly with any of its subclasses (derived classes) without any issues or **surprises**.


>Promotes Design by Contract


All child class should behave as their paren wants them too.
No child class should give any new/special meaning to parents method
Example: Runnable interface run() method, which should be used only for multithreading
But what is some class overrides it and use for some other function..?



## Problem Statement
> When ever you are impl an interface/parent method, do what the method wants to be done.

Lets say we have a requirement
- Bird: add functionally Penguin, bird that cant fly


In V2 design if we try to add Penguin, we will a create class for it and impl all methods from Bird class including fly
So how we will provide impl of fly function ?
- Leave it empty? 
- throw exception?

Client POV is why fly() method is in Penguin class


But it will not be a good design if we provide fun of fly() to penguin. Its unexpected behavior.
> Unexpected behavior can break codes...
check this: https://x.com/GergelyOrosz/status/1502947315279187979?s=20&t=19DSxx_mg_R2BDN82Wn8JA


## Solution
>Ideal sol: If an entity does not support a behaviour, it should not have method to do the behaviour.

**1st solution:**
we can create two abstract class like: flyable abstract class and un-flyable abstract class
- If we create classes based on different behaviors then, we might end up creating a lot of classes...
- what about birds that can fly and do not make sound?, birds that can fly and do make sound
  birds that can not fly and do not make sound, birds that can not fly and do make sound
  four abstract classes?

**Problems  With 1st solution**
- Class explosion: too many classes
- Get all birds that can fly(). so there will be two list birds that can fly and do not make sound?, birds that can fly and do make sound



Problem: Some birds demonstrate a behaviour while other birds do not.
         Only bird showing that behaviour should have that method
         I should be able to create a list of birds that have a particular behaviour


Solution
- In prev sol, we tried to use Class to represent behaviours, but they represent Ideas,
- Use Interface to represent behaviours
- So if any bird wants to fly then it should implement Flyable interface

> **We should use interfaces to represent behaviours.**