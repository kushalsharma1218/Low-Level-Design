# Facade Design Pattern
> When ever you are doing too much work within a class or a method, create a helper method/class to that work

> Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.


## Definition
Facade means boundary or outside of the building
- provide cleaner or a simplified view of a building







## Problem Statement
When you place an order from amazon, you just click some buttons enter few details and done
But on backend amazon does a lot of things like
- update Inventory
- Notify seller
- Notify the logistics
- track and send updates
- app notifications
- cancel Order


Let suppose this all happen in one class, so much complexity in one class ans its not good to so much work in one class/method


## Solution

We just need to create a helper class, and assign all the task, we were doing to this helper class
Client just need to call this helper method and then helper have to perform all the work.


>You can isolate your code from the complexity of a subsystem.

> A facade can become a god object coupled to all classes of an app.