# ISP (Interface Segregation)

> The Interface Segregation Principle (ISP) suggests that a class should not be forced to implement methods it doesn’t need. 
> In other words, a class should have small, focused interfaces rather than large, monolithic ones. 
> This helps to avoid unnecessary dependencies and ensures that classes only implement the methods they actually need.

> Clients should not be forced to depend upon interfaces that they do not use

- Interfaces should be as light as possible
- There should be as less methods as possible
- Ideally interfaces should have one method :: **Functional Interfaces**, Example: Lambda Expression


**Example**
For example, if you have an interface with 10 methods, but a class only needs 2 of those methods, 
it's better to split the interface into smaller, more specific interfaces. 
This way, each class can implement only the methods it actually needs, making the code easier to manage, understand, and maintain.

**In short, ISP encourages creating specific, purpose-focused interfaces instead of large, general ones.**