# How to approach a LLD Problem

## Design Round
**Steps ypu should follow**
1. Gather requirements (V.IMP), 10 - 15 mins
    - ex, do you want to build the core module like ticket booking
    - Ask clarifying question
    - Before start coding, complete this step
2. Use case diagram, 5- 8 mins
3. Class Diagram, 10 - 12 mins
    - classes that represent your entities
    - Interfaces
    - Design Patterns
4. Schema Design (Optional) 5 - 8 mins
5. Working code


## Machine Coging round, 2 - 3 hr
**Steps ypu should follow**
- Here you will receive a document that has detailed problem statement
1. Clarifying question, 5-10 mins
2. Class Diagram, 10 - 15 min
3. Schema Design, 8 - 10 min
4. Working code, 1 hr 30 min



We will follow superset of these two design

- Gather requirements
- Clarifying question
- Use case diagram
- Class Diagram
- Schema Design
- Working code


## Overview => expectation of the interviewer
1. How are we taking input from the user, CMD or Web API
2. What kind of system are we designing, Interactive System, Entity Design or Web App
3. Kinds of system
    - Entity: Just represent classes in terms OOP
    - Interactive: Mostly its CMD, GAMES No Persistence
    - Web App: We need persistence, Like store the state in db, Parking Lot

> **_NOTE:_**
> - Interactive System => Tic Tac Toe, Snakes and ladders
> - Entity Design => Design a pen, Ice Cream, Bird, Coffee machine
> - Web App => Application that introduce Rest APIS
>
> For persistent temp local memory we can use like storing the data in array/map instead of db


**There can be two types of problem statement**
1. We already know about system
    - align ourselves with interviewer
2. We Don't know about system
    - You ask interviewer about the system

Common Steps
- Only Entity design or do they want to impl as well
    - If impl
        - Do we have to persist data
        - How the system will take input

    