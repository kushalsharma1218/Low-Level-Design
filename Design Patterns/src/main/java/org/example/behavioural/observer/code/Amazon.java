package org.example.behavioural.observer.code;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
    private static Amazon amazon;

    private static List<OrderPlacedSubscriber> orderPlacedSubscribers = new ArrayList<>();

    public void register(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscribers.add(orderPlacedSubscriber);
    }

    public void unRegister(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscribers.remove(orderPlacedSubscriber);
    }

    private Amazon(){}

    public void orderPlaced(){
        // generate invoice
        // inventory update
        // ....other sorts of work
        for (OrderPlacedSubscriber orderPlacedSubscriber : orderPlacedSubscribers) {
            orderPlacedSubscriber.notifyOrderPlaced();
        }
    }

    public static Amazon getInstance(){
        if(amazon == null){
            synchronized (Amazon.class){
                if(amazon == null){
                    amazon = new Amazon();
                }
            }
        }
        return amazon;
    }
}
