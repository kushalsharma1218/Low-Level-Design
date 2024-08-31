# Solid Principles
- S -> Single Responsibility Principle
- O -> Open and close principle
- L -> Liskov's substitution principle
- I -> Interface segregation
- D -> Dependency Inversion

> Following these principles can result in a system that is more comprehensible, flexible, and modular, which is easy to scale, modify, and test.


# SRP: Single Responsibility Principle
> SRP: Every code unit (One class, method, package) in your code should have exactly one well-defined responsibility.
> This principle states that a class should have only one reason to change, meaning it should be responsible for only one part of the software’s functionality.


## Problem statement
Design a bird, there can be many types of birds some can fly some may not.



- Limitations
    1. Bad code readability, so many if else
    2. Testing code is also difficult, lets say if we add more birds, we have to add in test also
    3. Lets say if multiple devs are working for impl of different birds, huge merge conflicts
    4. Violates Single responsibility principle, Lets say if theres a change in impl of a bird,
       then we have to make change in bird class... i.e. Bird class has multiple responsibility like how a sparrow flies, crow flies.
       - Bird class will have to change when the behavior of bird changes.
       - Bird is also responsible for shared attributes b/w different birds

### How to identify SRP violation
1. method with multiple if else
2. monster methods: method doing much more then what they are meant to do
    EX: theres a method
    savToDB(user){
        String query = ""
        User u = new User(); // bunch of steps here to create user
        createDBCon(); // bunch of steps here
        save();
    }

    - this method was created to perform saveToDB, but its creating query, user, and db con
    - duplicate code, if we have to save some other entity
    - **DRY: don't repeat yourself**

3. Utility/Helper/Utils classes: These classes do not have one responsibility
    Sol: Divide utils, DateUtils, TimeUtils...