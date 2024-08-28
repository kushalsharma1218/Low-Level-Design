package org.example.behavioural.observer.code;

public class InventoryUpdateSubscriber implements OrderPlacedSubscriber{

    public InventoryUpdateSubscriber(){
        Amazon.getInstance().register(this);
    }
    @Override
    public void notifyOrderPlaced() {
        System.out.println("Inventory updated");
    }

}
