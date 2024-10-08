# Singleton Design Pattern

## Definition:
- Allows you to create a class for which only one object can be created
- Singleton are always immutable
Double Check Locking, the best way to implement singleton when performance is concern
Ex: Logger



**But why dot we need that?**
1. A Class which is having shared resource behind the scenes
    Example: Db Connection
    - Memory save
    - Every db connection will have a tcp con with database, so only one dbCon and one tcp con
    - multiple classes can access this one db con and use parallel also because db con will be a immutable object
2. Creation of object sometime can be expensive and only one object is needed
    DBHost(Url, host, password)
3. Common resource



**When we don't need Singleton**
- When we change attributes in the object, every object we want different attribute values
    DbCon(url, host, ....){
        changeUrl()
    }



## Problem Statement / Implementation
Simple singleton
- Till the time class has a constructor, we cant make a single object. So, we need keep constructor private, but we need to create an object
- Inorder to create an object we need to call constructor
- We need some method in class so using that client can get object... without using object, i.e static method
- Create a static method, and return object from that method,
  but now every time if client calls this method, a object will be created
- In this method, we have control over if the instance is already created don't create again
- Take a private static DbCon(Your singleton class) variable at class level
  and check if variable is null create object else just return the variable


**But how will it perform in multithreading env...?**
- If there are two thread trying to get object at same time, then we might end up creating two instances
- So this is prone to error when the object is created for first time in concurrent env



### Solution 1: Eager loading/execution
- can we initialise instance at the time of class loading..? Yes
  Just initialise when we are declaring instance
  private static MultiThreadedDbConnection dbConnection = new MultiThreadedDbConnection();

**But there are problems with this**
- Application startup time will increase, if there are 10 such singleton classes and all of them create object
  during class loading... startup time of app increases.
- Here instance is created even though the client has not requested it , and it will cause the memory leak
- We can not pass any info to constructor, to init variables. So you can't give variable config when creating instance.
- Lets say we have logger class, and we want to create instance of that class based on some config data lke env.
  We cannot have the the value of config at class loading time


**What we can do now?**
- We need to create object at runtime not when class loading
- Want it to work fine in concurrent environment

### Solution 2: Using Locks
- make getObject function synchronised

But in this case performance is impacted
synchronized will make our process slow, because remaining thread has to wait till first complete.

Lets say we have synchronised getObjectMethod

```java
class Singleton {
    public synchronized static MultiThreadedDbConnection2 getDbConnection() {
        // ------------------------------------> lock
        if (dbConnection == null) {
            dbConnection = new MultiThreadedDbConnection2();
        }
        return dbConnection;
        // ------------------------------------> unlock
    }
}
```

**Flow**
- T1 and T2 two threads that try to create Singleton class object at same time.
- T1 acquires the lock and created instance,
- Now T2 will acquire lock, and check if instance is null then will return object...
- But why we want t2 to acquire lock, cant we simply return object

**Synchronised block is slow, so we must write code such that our threads avoid acquiring locks**

### Solution 3: Double Check Locking

We can use Double Check Locking, the best way to implement singleton when perm is concern

```java

public synchronized static MultiThreadedDbConnection2 getDbConnection() {
   if (dbConnection == null) {
       // lock
       if (dbConnection == null) {
           dbConnection = new MultiThreadedDbConnection2();
       }
       // ------------------------------------> unlock
   }
   return dbConnection;
}
```
**Flow**
- T1 and T2
- T1 acquires the lock and created instance,
- Now T2 will acquire lock, and check if instance is null then will return object...
- After this all other threads will not acquire lock and will just return object

**First we were taking lock outside, now we are taking lock inside, every thread will not acquire lock now**


**Problems with 3rd Approach**
1. Double check loading fails to handle serialization
   - Serialization: Object converted to bytes[]
   - Deserialize: bytes[] converted to object
     So using serialization and deserialization we can create two objects...
     When deserializing a class, new instances are created. Now it doesn't matter the constructor is private or not.
     Now there can be more than one instance of the same singleton class inside the JVM, violating the singleton property.
2. Reflection
    Using reflection anyone an change the private access modifier of the constructor to anything they want at runtime using reflection.

### Solution 4: Solving serialization problem
The solution is that we have to implement the readResolve method, which is called when preparing the deserialized object before returning it to the caller.
The solution is as follows.
```text
protected Object readResolve()
{
   return INSTANCE;
}
```

### Solution5: Final solution for solving all above problems
Use Enums
- Enums are inherently serializable
- Enums are inherently protected against reflection.
- If you try to create an instance of an enum using reflection, it will throw an IllegalArgumentException.
- This is because enums do not have public constructors, and their instances are created by the JVM at the time of class loading.
- Enums are thread-safe by default and ensure that only one instance of the enum is created per JVM.

**So all our problem are solved by ENUMS**



## Pro and cons
Pros
- Resource efficiency
- Creating a new object is inefficient ops, it created object and caches it

Cons
- Its difficult ot test singleton class, we usually test using Mocks of object,
  if you want to test data with different objects(data) but in singleton only one object will be created