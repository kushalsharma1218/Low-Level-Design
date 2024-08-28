package org.example.behavioural.observer.code;

public class GenerateInvoiceSubscriber implements OrderPlacedSubscriber{

    public GenerateInvoiceSubscriber(){
        Amazon.getInstance().register(this);
    }
    @Override
    public void notifyOrderPlaced() {
        System.out.println("Invoice generated");
    }
}
