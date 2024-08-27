package org.example.structural.flyweight.code;

public class FlyingBullet {
    int[] direction; // 24 bytes
    double speed; // 8 bytes
    int[] currentCoordinate; // 24 bytes
    int[] targetCoordinate; // 24 bytes
    Bullet bullet; // 8 bytes // this will store ref
}
