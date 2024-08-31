# OCP: Open close principle

> The open-closed principle states that software entities (classes, modules, functions, and so on) should be open for extension, but closed for modification.

> Adding new feature should require no change or less change in already written code

> By following the Open/Closed Principle, your code becomes more extensible and modular, making it easier to add new functionality without the risk of introducing errors into the existing code.


### Problems if we change in V1 Design
- In V1 design, if we have to add bird, then we will need to change fly(), makeSound(), walk() function
- Test case updates
- regression issues: something that was already working fine, after this change it breaks..


### But what can be the solution..?
- Either we make Bird class interface or a abstract class. Brd class has some attributes, so lets go with abstract class.
- Lets the bird be responsible for generic details and not the specific one.



V2 Design
- We change Bird class to abstract class due SRP and OCP problems
- Bird class has lesser reasons to change
- Now, every bird is responsible for its own methods implementations,
  so, any change in impl of any bird will not affect other birds impl, so testing is easy now


But, why do we need bird class now?
- so that we have a common type to represent all birds, List<Bird>, easy for impl and lesser code