# Factory Design pattern

## Types
- Factory Method
- Abstract Factory
- Practical factory


## Factory Method Design pattern

### Definition
> Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. 
> In simpler terms, it's a way to create objects without directly specifying their exact type.

>The factory method is a design pattern that provides an interface or abstract class for creating an object and allows its subclasses to decide which class to be instantiated.

**When to use**
- We can create a method factory method, when there is decision-making performed for object intantiation
- If your method involves complex object creation, including multiple conditional checks, parameter handling, or dynamic type selection, a factory method can encapsulate this logic and promote cleaner code.
- If your method needs to create different variations of an object based on different conditions or parameters, a factory method can provide a more flexible and maintainable approach.
- You anticipate future changes or additions to the types of objects you need to create, a factory method can provide a more adaptable solution.

### Problem Statement
Lets say we have a class UserService
```java
class UserService{
    DataBaseCon dbCon = ......;
    
    void createUser(){
        Query query = db.createQuery("");
        query.execute();
    }
    
    void saveUser(){
        Query query = db.createQuery("");
        query.execute();
    }
}
```
Let's decide what's DataBaseCon should be class, interface or abstract class
If DataBaseCon was a class then **Dependency Inversion Principle** will be violated, it should be interface or abstract class.

What about Query ? Query should also be a interface or abstract class,
because in db.createQuery() can return a sql, psql, mongodb query... . So we don't tightly couple it.


Lest discuss about DatabaseConnection
```java
interface DatabaseCon{
    Query createQuery();
    void connect();
    createPool();
    log();
}
```

if we talk about createQuery() method, what's its purpose?
> Its purpose is nothing but to return a object of Query and that can be of Sql Query or No-Sql query..
> createQuery() is a factory method

How we will implement this if we don't have factory method
```java
class UserService{
    DataBaseCon dbCon;
    Query query;
    
    UserService(){
        if(dbCon instanceof MySqlDB){
            query = new MySqlQuery();
        }
        else if(dbCon instanceof NoSql){
            query = new NoAqlQuery();
        }
    }

    void createUser(){
        Query query = db.createQuery("");
        query.execute();
    }

    void saveUser(){
        Query query = db.createQuery("");
        query.execute();
    }
}
```

Problem
- Ocp violation, if in future some other database added then we will change in existing code


### Abstract Factory
Lets consider the same DatabaseCon interface with multiple Factory Methods

```java
interface DatabaseCon{
    Query createQuery(); // 1st factory
    void connect();
    createPool();
    Transaction createTransaction(); // 2nd factory
    Updater createUpdater(); // 3rd factory
    log();
}
```
DatabaseCon has 3 factory methods


**Responsibilities of DatabaseCon**

- Holds all the methods/behaviours of a databases.
- It has three factory methods :- createQuery(), createTransaction(), createUpdater();
- It holds a lot of factory methods and the class which implements it wil have the responsibility to return corresponding objects of different types.


> Acc to ISP, Interfaces should be light as possible


# Abstract Factory

## Definition
> Creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

> In simpler terms, it's like a general contractor who knows how to choose the right components (like doors and windows) for a building project without specifying the exact details of each component.




Divide the interface into 2 separate interfaces, 1st interface will hold all methods related to it
and 2nd method will hold all the factory methods

```java
interface DatabaseCon{
    void connect();
    createPool();
    log();
    DatabaseFactory createDatabasefactory();
}

interface DataBaseFactory{
    Query createQuery(); // 1st factory
    Transaction createTransaction(); // 2nd factory
    Updater createUpdater(); // 3rd factory
}
```
But why do we divide them?
DatabaseCon was a heavy interface and had multiple responsibility thus violates SRP.


**But how will a class will implement DatabaseCon**

```java
class MySqlDatabase implements DatabaseCon{
    void connect(){}
    createPool(){}
    log(){}
    DatabaseFactory createDatabasefactory(){
        return MySqlDatabaseFactory();
    }
}

class MySqlDataBaseFactory implements DataBaseFactory{
    Query createQuery(){
        return MySqlQuery();
    }
    Transaction createTransaction(){
        return MySqlTransaction();
    }
    Updater createUpdater(){
        return MySqlUpdater();
    }
}
```


```java
class UserService{
    DatabaseCon dbCon;
    
    UserService(){
        dbCon = MySqlDataBase();
    }
    
    createQuery(){
        DataBaseFactory dataBaseFactory = dbCon.createDatabasefactory();
        dataBaseFactory.createQuery();
    }
}
```

> This is also known as separation of concern
> Widely used in UI libraries


## Pros
- Factory Method Pattern allows the sub-classes to choose the type of objects to create.
- Factory design pattern provides great extensibility that lets us add new classes without changing the application.
- Factory design pattern leverages loose coupling and eliminates hard binding the application-specific login in the code.
- The factory method returns the interface. So, it can work for any concrete product implementation.
- Using a Factory allows the consumer to create new objects without having to know the details of how they're created, or what their dependencies are - they only have to give the information they actually want.

## Cons
- It introduces additional classes and interfaces, adding a layer of abstraction that can make the code more complex to understand and maintain, especially for those unfamiliar with the pattern.
- Testing the factory logic itself can be more complex.
- It’s important to use the Factory Method pattern judiciously to avoid over-engineering the application. Simple object creation can often be handled directly without the need for a factory.

# Practical factory
So far we have learnt Factory method that return a corresponding object and abstract factory that also in some way 
returns a corresponding object

Practical Factory Will provided methods create object of itself based on different params. 

```java
class DatabaseFactory{
    DataBaseFactory createDbFactory(String name){
        if(name.equals("MYSQL")){
            return new MySqlFactory(); 
        }
        else return new NoSqlFactory();
    }
}
```

> Practical factory: DatabaseFactory is a practical factory that return object of DatabaseFactory.

**Where to use**
- When ever there are multiple variants of a class, and you want to create an object of the correct variant based on some parameters


> Spring bean factory in spring framework uses factory pattern