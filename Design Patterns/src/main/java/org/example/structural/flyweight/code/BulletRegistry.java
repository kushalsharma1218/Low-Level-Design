package org.example.structural.flyweight.code;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    private Map<String, Bullet> bulletMap = new HashMap<>();

    public void add(String type, Bullet bullet){
        bulletMap.put(type, bullet);
    }

    public Bullet getBullet(String type){
        return bulletMap.get(type);
    }
}
