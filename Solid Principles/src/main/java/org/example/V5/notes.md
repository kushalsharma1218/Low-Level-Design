# DIP ->  Dependency Inversion principle

> No two Concrete classes should directly depend on each other they should depend on each other via a interface

> The principle consists of two core concepts: high-level modules should not depend on low-level modules, 
> and both should depend on abstractions.

> Simply put, when components of our system have dependencies, we don’t want directly inject a component’s dependency into another. 
> Instead, we should use a level of abstraction between them.

> **A good rule to apply is that higher-level components should not depend on a lower level.**

> Concrete classes change frequently, while abstractions and interfaces change much less

**But why it is called dependency inversion?**
Class A Was dependent on Class B and vice versa for object creation
Now, Class A depends on Interface C and Class B depends on Interface C, inverted dependency


## Problem Statement
Suppose You have a abstract bird class and four child classes as Sparrow, Crow, Piegion, Penguin
And now Sparrow and crow have same way of flying and Peigion and penguin have same way of flying..
So now question is how would you remove duplicate codes?

## Solution
**Naive**
You might say okay lets create two more classes SparrowCrowFlyingBehaviour and PenguinPeigionFlyingBehavior
that will contain the fly() impl. See V5.NaiveDesign


**Problems**
Do you remember phonepe yes bank case?
- There is direct dependency between class, tight coupling
- Sparrow and Crow depends on SparrowCrowFlyingBehaviour which is not a good design
- **Two classes should not be dependant on each other, they should depend on each other via a interface**
- Classes are tightly couples with each other

Lets suppose if we want to change the way to sparrow flying, then we would need a lot of code changes
- Method signature may change
- fly() method impl will change

In order to minimise changes we introduced solid principle....So

> **We code to an interface not to implementation**

**If we have used interface then the change is more flexible**
We can fix the contract and if in future we want to change the flying behaviour then we just need one line code change
Everything else remains same
