package org.example.behavioural.observer.code;

public class Client {
    public static void main(String[] args) {
        Amazon amazon = Amazon.getInstance();
        GenerateInvoiceSubscriber generateInvoiceSubscriber = new GenerateInvoiceSubscriber();
        InventoryUpdateSubscriber inventoryUpdateSubscriber = new InventoryUpdateSubscriber();
        amazon.orderPlaced();
    }
}
