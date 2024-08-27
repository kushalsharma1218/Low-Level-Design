package org.example.behavioural.strategy.code.algos;

import org.example.behavioural.strategy.code.PathCalculator;

public class WalkPathFInder implements PathCalculator {
    private static WalkPathFInder walkPathFInder;
    @Override
    public String findPath(String from, String to) {
        return "Walk Path Finder";
    }

    private WalkPathFInder(){}

    public static WalkPathFInder getInstance(){
        if(walkPathFInder == null){
            synchronized (WalkPathFInder.class){
                if(walkPathFInder == null){
                    walkPathFInder = new WalkPathFInder();
                }
            }
        }

        return walkPathFInder;
    }
}

