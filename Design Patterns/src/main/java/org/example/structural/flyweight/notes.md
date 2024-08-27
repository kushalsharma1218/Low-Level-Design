# Flyweight Design Patterns


## Definition
If you have a class whose objects demostrate intrnsic and extrinsic peroperties 
and if you see that there is extra memory usage because of this, you consider using Flyweight

## Problem Statement And Solution

Build a UI for a online multiplayer game like pubg
- There should be a area, like ground where players are allowed to play
- Total 100 players
- At the end only one player who is alive wins
- 2 guns/player
- total 300 bullets/player
- In these games, complete state of a game downloaded in machine for every player
  When you start the pubg game it take around 15-20 mins to load the game. 
- The changes are transferred to every machine as the game starts and moved ahead.
- Everything is going to be a state, be it location, guns, bullets
- 1 Pubg game We can have at max 10 types of bullets

Attributes of Bullets
- radius of bullet, it can be 5.6mm or 7.62 mm :: Double (8 bytes)
- color :: enum/int (4 bytes) 
- weight :: double (8 bytes)
- max damage :: int (4 bytes)
- direction, if they are fired,we can use vector to store direction :: xi + yj + zk, 3 double
- speed :: double (8 bytes)
- max range :: int (4 bytes)
- current coordinate :: 3 doubles (24 bytes)
- target coordinate :: 3 doubles (24 bytes)
- image :: byte[] (1 KB max)

Total storage: 108 bytes + 1 KB = 1.1 KB

In 1 Pubg Game we have 100 players, every player have 300 bullet, total bullet = 30,000
and all the bullet can have different specification.

Lets say, 1 Pubg Game nearly = 1000000 bullets
Total ram used by bullets would be around = 1.1 KB * 100000 = 0.11 GB = 100 MB 

But this much storage for bullet itself is not good. We need optimise our design

> Design can make so much different in memory optimisation as well.

**Observation**
- If we have 1000000 bullets, not all the bullets will be distinct from each other.
  There are some properties that would be same for some bullets like radius, color...


> Often we have class that have 2 kinds of properties
> - Extrinsic, values of which might change with time like direction, speed
> - Intrinsic, values of which remains same across time.

> In condition like this, we use flyweight pattern to save memory usage


### How to implement 
1. Divide the class into two class 
   - With intrinsic properties
   - With extrinsic properties
   
    ```java
    // Intrinsic class
    class Bullet {
        double radius; // 8 bytes
        ColorEnum color; // 4 byes
        double weight; // 8 bytes
        double maxDamage; // 8 bytes
        double range; // 8 bytes
        byte[] image; // 1 KB
    }
    
    // extrinsic class
    class FlyingBullet {
      int[] direction; // 24 bytes
      double speed; // 8 bytes
      int[] currentCoordinate; // 24 bytes
      int[] targetCoordinate; // 24 bytes
      Bullet bullet; // 8 bytes
    }
    ```
   **We will just create 10 object of Bullet for 10 types and use them around**
   We can use registry design pattern to store these 10 bullet objects
   > **_NOTE:_**  here bullet object does not store the copy of bullet 
   > Instead it will store the ref of actual object
   
Lets say now Bullet take 1 KB storage and Flying Bullet take 88 bytes. 
And Pubg has 10 types of bullets, so now total space taken by bullets = 10 * 1 KB = 10 KB
And Pubg has 10 types of bullets, so now total space taken by bullets = 10 * 1 KB = 10 KB
And there are still 100000 bullets Flying bullets = 100000 * 8.8 bytes = 8.8 MB
Total space = 8.8 MB + 10 KB -> 9 MB

> We have reduced memory consumption of 100 MB to 9 MB



