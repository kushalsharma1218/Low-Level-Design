# Builder Design Pattern

#### **Definition**
Allows us to create a object where we have these constraints
- Too many attributes
- Validate before creating object, like if we all the checks passed then only create object


> Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.


#### **Problem statement**
There is a class with a lot of attribute

```java
class Student {
    private String fName;
    private String sName;
    private String age;
    private String address;
    private String classNumber;
    private String batch;
    private String addhar;
    private String pan;
    private String idProof;
    private String phoneNumber;
}
```
How will you create the object of class student?


#### **Solutions**
**Approach 1**

We can use no arg constructor to create object and then set the attributes using getters and setters
```java
Student student = new Student();
student.setfName("some name");
student.setsName("some name");
```

Problems
1. If we don't use any library, we have to create a lot of getters and setters
2. What if we want to validate an object of class **even before creating a object**
   - let's say no student with gradYear > 2022 should be allowed
   - phone number should be valid. (we can do with regex, but what if no regex is present)
   - as soon as you new Student() object is created already, we don't want to create object if validation failed

**Approach 2**

**Validations should happen in constructors**

How?
- Inorder to perform validations in constructor we have to use parameterized constructor
- So we have create constructor that accepts all parameters

```java
class Student {
    private String fName;
    private String sName;
    private String age;
    private String address;
    private String classNumber;
    private String batch;
    private String addhar;
    private String pan;
    private String idProof;
    private String phoneNumber;
    
    Student(String fName, String sName, String age....){
        // validate here
    }
}
```

**Problems**
1. If there are lot of parameters, at time of object creation it would be difficult to identify parameter order. making it difficult to understand
2. More prone to errors, Orders of parameters can be wrong, we have to remember the order
3. In the future i want to add one more attribute in the constructor then in all clients s i have to add the values to the same in many places
4. What if we dont have the required parameter values ? let's say we only know fName and sName and age and want to create object. So either you will have to pass null values for other params or you wil have to create more constructors (Constructor overloading),

Problem with constructor overloading
- Too many constructors, Lets say we have N attributes, and if we find combinations for them as 2^n, 
- We might end up creating 2^n constructors for every combination of attributes 
- There might be soe combinations, where overloading won't be possible due method signature (order of params)

> So surely constructor overloading is not the solution and neither we can pass null values

**Approach 3**

Lets say we have only one constructor in student class that take a ds and initializes our object
**We need a DS such that**
- That allows us to pass multiple values with each having a specific name
- It should allow us to provide only those values which we have, other value we don't care


Can we use Map?
yes, we can use key values and provide fields names as keys and values for those keys
Map<String, Object> where key as FieldName, and value of value of that field



Problem with Map
- Client might pass wrong field name, data will not map then in constructor
- Client might pass wrong value for a field, can cause data mismatch error  this.age = (Integer) classValues.get("age");
- And if we try to put validation map.containKey() and data cast check, then your constructor will be bloated with lot of validations
- Error prone code


**Approach 4**

- We need something like of map such that we should be allowed to have different values, where one value can be recognised by a diff name
- It should have compile time check for keys, so we dont have validate if field is present or not
- It should have compile type check for data types of values to avoid runtime exception

So we cant use map, list... 
**But we can use a class datatype**

Lets say we have a class
```java
class Builder{
   private String fName;
   private String sName;
   private String age;
   private String address;
   private String classNumber;
   private String batch;
   private String addhar;
   private String pan;
   private String idProof;
   private String phoneNumber;
        }
```
and we create object using
```java
Builder builder = new Builder();
builder.sName = "some name";
builder.age = "some name";
builder.address = "some name";
builder.classNumber = "some name";
```


How to use it in student class


```java
class Student {
    private String fName;
    private String sName;
    private String age;
    private String address;
    private String classNumber;
    private String batch;
    private String addhar;
    private String pan;
    private String idProof;
    private String phoneNumber;
    
    
    Student(Builder builder){
       // validation needed fpr business logic 
    }
}
```

> Point is you will have flexibility to choose which attributes to pass with calling only those setters. Rest will be default.



Last approach will work fine, but when you see from client perpective, you will find that Student class doen't provide any info how to create object of student
How will client know what is builder/builder class ?

We can provide a static method in Student class so that we can introduce Builder and can be accessed without student object

```java
class Student {
    private String fName;
    private String sName;
    // ...more attributes
    
    public static Builder getBuilder(){
        return new Builder();
    }
    
    Student(Builder builder){
       // validation needed fpr business logic 
    }
}
```


But did you see your Builder class, it doesn't build anything actually it more kind of a helper class
Out main objective is to create Student object, btu client has to first create helper object and then student object

Lets give Builder class a method so that it can itslef create the object of Student


```java
class Builder {
    private String fName;
    // ....more attributes

    // getters and setters

    public Student build() {
        // put all business logic validations here now
       return new Student(this);
    }
}
```

**Now actually builder is building object**


Lets see client side code now

```java
public class Client {
    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.setFName("someName");
        builder.setSName("someName");
        
        Student student = new Student(builder);
    }
}

```



But can we make process a bit more easier for client by using build method
We want to achieve something like this

```java
import org.example.creational.builder.classdatatype.Student;

public class Client {
   public static void main(String[] args) {
      Student student = Student.getBuilder()
              .setFName("someName")
              .setSName("someName")
              .build();
   }
}
```
Lets do some changes in Builder class to achieve something like this.
We have to make setters return object of builder

```java
class Builder {
    private String fName;
    // ....more attributes

   public Builder setfName(String fName) {
      this.fName = fName;
      return this;
   }
   
    public Student build() {
        // put all business logic validations here now
       return new Student(this);
    }
}
```


Theres still a loop hole and bypass technique
**Student constructor is still public and can be used to create object**

Make constructor private but if we make it private then we wont be able to call return new Student(this);

**Make Builder class static inner class of Student so that we can call student constructor from build()**


```java
public class Student {
    private String fName;
    // ... more attributes

    private Student(Builder builder) {
        // create object
    }


    public static class Builder {
        private String fName;
       // ... more attributes


        public Builder setfName(String fName) {
            this.fName = fName;
            return this;
        }
        
        // ..more setters
        
        // getters

        public Student build() {
            // put all business logic validations here now
            return new Student(this);
        }
    }


    // method introduced to give client context of builder
    public static Builder getBuilder() {
        return new Builder();
    }
}
```