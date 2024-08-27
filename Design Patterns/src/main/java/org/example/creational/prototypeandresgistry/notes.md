# Prototype and Registry Design Pattern

## Definition
> Often there are scenarios when we don't want to create object from scratch 
rather we prefer creating a copy of template/prototype and then later you can make the specific changes


Example
Consider a notebook which has
- noOfPages
- type : blank/ruled/dotted
- height
- weight
- frontPageDesign
- funFact/games

Classmate want t create 1000 notebooks of a4 size page with 120 pages each.
Can we say these are common attributes that will be fixes in every notebook
- noOfPages
- type : blank/ruled/dotted
- height
- weight

and these are extra attributes will be different
- frontPageDesign
- funFact/games

**So cant we create a A4_120_ruled design/prototype and use that to create 1000 copies
A4_120_ruled is called Prototype**


> So when the factory work, it creates a copy of a prototype and adds the value of fun facts and front page design
> All thing that are generic we can keep that in prototype and all those thing which are specific we can define them in specific copy objects


Example 2

```java
class SearchApiCall {
    //fixed values
    private String url;
    private String path;
    private String token;

    private String query; // this can be different for every search call
}

class Client{
    public static void main(String[] args) {
        SearchApiCall prototype = new SearchApiCall();
        SearchApiCall copy = prototype.copy();
        copy.setQuery("something");
    }
}
```

Once prototype is created, we just have to change some attributes.






## Problem statement
Given an object of a class, you have to create copy of that object

```java
class Client {
    public static void main(String[] args) {
        Student st = new Student();
        
        //create copy of st
    }
}
```


## Solutions

### Approach 1
We can copy all attributes from st to copy object

```java

class Client {
    public static void main(String[] args) {
        Student st = new Student();
        Student copy = new Student();
        
        copy.setName = st.getName;
        // set other attributes
    }
}
```

#### Problems

- Client will need to know all the impl details of student, like what all attributes are there.
- If we add a new attribute, then we have to change in all copies code.... OCP violation
- Student class might have private attributes and it may happen it don't have getter and setters for those attributes

Lets discus one more problem
```java
class Student{
    private String name;
    private Integer age;
    private String phoneNumber;
}

class IntelligentStudent{
    private String rollNumber;
}

/** previous code will not work here, we have to check which type of object st is*/
class Client {
    public static void main(String[] args) {
        Student st = new Student(); or new IntelligentStudent();
        if(st instanceof Student){
            // create copy object
            copy = new Student()p;
        }
        if(st instanceof IntelligentStudent){
            // crate copy object
            copy = new IntelligentStudent();
        }
    }
}
```

We have to check which type object it is actually using multiple if else, and if we have more subclasses then we have to add more checks
Thus, This also violates OCP principle


### Approach 2
Using copy constructor

```java
class Student{
    private String name;
    private Integer age;
    private String phoneNumber;
    
    Student(Student st){
        // create copy
    }
}
```
okie, so our first 2 problems will be solved using this.
**But we can still pass subclass object in constructor... so we still have those check implemented. so this still violates OCP principle**


**Problem so far we are facing**

- If a client wants to create a copy of a object, having the logic to create copy within the client is prone to errors, client doesn't know what attributes student has.
- Ideal solution can be client outsources the work to create the copy of the object itself

### Approach 3

> Ideally it student class job to provide a method so that client can easily create copy.. irrespective of object, its parent should be Student

```java
class Client{
    public static void main(String[] args) {
        Student st = new Student(); or IntelligentStudent();
        Student copy = st.copy();
    }
}
```

Benefits
- No tight coupling, so whenever the student change we dont have to make changes in client
- No OCP violation, I if make any change in student we dont have to change in client code.
- Then by this way we can also resolve the inheritance problem... by having copy method in all the child classes using overriding
- Client is free, no suprises...


> Also, here we are doing dynamic binding, if st = new Student() then student clas copy method will be called and if st = new IntelligentStudent(); then IntelligentStudent copy method will be called. So we don't have to check what type of object we are copying. (if else conditions)

> We will need to define copy method in every subclass cause, Subclass might have some attributes that are not present in parent class, also if st = new IntelligentStudent() then we want to copy IntelligentStudent class object, so its based on subclass also.


```java
class Student{
    private String name;
    private Integer age;
    private String phoneNumber;
    
    Student copy(Student st){
        Student copy = new Student();
        // set properties
        
        return copy;
    }
}

class IntelligentStudent implements Student{
    private String rollNumber;

    IntelligentStudent copy(IntelligentStudent st){
        IntelligentStudent copy = new IntelligentStudent();
        // set properties

        return copy;
    }
}

/** previous code will not work here, we have to check which type of object st is*/
class Client {
    public static void main(String[] args) {
        Student st = new Student(); or new IntelligentStudent();
        Student copy = st.copy();
    }
}
```


But what if we forget to impl copy method in subclass, then parent class copy() method will be called, it will give you runtime error


### Problems
- All child classes must override the copy() method, otherwise it can lead to errors.


### Approach 4
If we have a template such that using which we can create object just by changing some fields
```java
class Student{
    private String name;
    private Integer age;
    private String phoneNumber;
    private String batchAvg;
    private String batchName;

    Student copy(Student st){
        Student copy = new Student();
        // set properties

        return copy;
    }
}
```

Can we say batchAvg and batchName are two fields that are going to be same in every object
So can we define a template, a object that we can use to create other students

Lets say registry is what we use to store different prototypes
```java
class Client {
    public static void main(String[] args) {
        Student copy = registry.getPrototype(batchName).copy();
        copy.setName = "Something";
//        .. set other attributes
    }
}
```

This way we can create multiple object using a common template or prototype.



## Implementation Steps
1. Declare a method clone() (copy) in the class which you want to create prototype for.
   - clone() will be responsible for creating a copy of object
   - If you have child classes then all child must override the parents clone method
2. Store the prototypes in a registery

    ```java
    class StudentRegistry{
        Map<String, Student> registery;
        public static void register(String key, Student student){
            
        }
        
        public static Student get(String key){
            
        }
    }
    ```
3. Prototypes are already define and are store at application start time
4. Client calls the registry to get prototype, it creates a copy of the prototype and client can use the copy

> Note: Client should have visibility how to use the prototype, what should be the key

> Registry can be singleton, because we only need one object

> ApplicationContext in Spring boot is example of registry

> Our main aim was to create copy of subclass object and we can't access the parent fields, 
> so in that case we created copy constructor so its initialize all variable of that class. check code 


> But if we are creating object using constructor why do we need clone(), 
> because method of correct class gets called automatically. Student can be any type, we don't have to check before copying else we have to check 
> if it is intelligent student then we will cal intelligent student constructor.  