# Observer Design Pattern

## Definition
> Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

**When to use**
- Main Benefit of OBS Pattern: Whenever something happens I might want to do a lot of other things in response to that.
- Use the Observer pattern when changes to the state of one object may require changing other objects, 
  and the actual set of objects is unknown beforehand or changes dynamically.


## Problem Statement And Solution
Consider a method that is doing a lot of work, and we in thinking of improving our design
created Helper class and handed all of our code to that method.



```java
class Amazon
{
    void placeOrder(){
        // call helper
    }
}

class OrderHelper{
    void placeOrder(){
        // generate invoice
        // inventory update
        // ....other sorts of work
    }
}
```

**Problem with OrderHelper**
- We might want to add new process in existing order placement
- For some product we might want different execution for order placement
- I cannot add or remove things at runtime, we cannot decide what not to do at runtime



> We can solve this problem using decorator pattern also

Lets Suppose you have a class that has some event, on execution of that event,
we want to execute multiple service one by one

Lets when order is places, we are calling multiple services and executing

But can we do it in reverse? Yes Reverse the dependency
**What if on execution of some event, all services come and say execute me pls.**

**Multiple service might want to execute when an event happens**

A has the event called **Publisher** and Service B, C, D called **Subscriber**

Create a new method in your publisher that allows subscriber to register them.

```java
class Amazon {
    private static List<OrderPlaceSubscriber> obsList;
     static void register(OrderPlaceSubscriber obs){
         obsList.add(obs);
     }
    void unRegister(OrderPlaceSubscriber obs){
        obsList.remove(obs);
    }
    
    void orderPlaced(){
         for(OrderPlaceSubscriber orderPlaceSubscriber: obsList){
             orderPlaceSubscriber.orderPlaced(); 
         }
    }

}

interface OrderPlaceSubscriber{ void orderPlaces();}
class ServiceA implements OrderPlaceSubscriber{
    public ServiceA(){ // service itself will register themselves
        Amazon.register(this);
    }
    void orderPlaces(){ }
}
class ServiceB implements OrderPlaceSubscriber{
    public ServiceA(){
        Amazon.register(this);
    }
    void orderPlaces(){ }
}
class ServiceC implements OrderPlaceSubscriber{
    public ServiceA(){
        Amazon.register(this);
    }
    void orderPlaces(){ }
}
class ServiceD implements OrderPlaceSubscriber{
    public ServiceA(){
        Amazon.register(this);
    }
    void orderPlaces(){ }
}
```



This piece of code will work, But for 2nd problem?
For that we need SubscriberManager that can remove subscriber from obsList