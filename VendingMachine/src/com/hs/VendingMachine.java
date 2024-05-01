package com.hs;

import com.hs.payment.PaymentStrategy;

class VendingMachine {
    private InventoryManager inventoryManager;
    private PaymentStrategy paymentStrategy;

    public VendingMachine(InventoryManager inventoryManager, PaymentStrategy paymentStrategy) {
        this.inventoryManager = inventoryManager;
        this.paymentStrategy = paymentStrategy;
        this.inventoryManager.registerObserver(new InventoryLogger());
    }

    public void processPurchase(Product product, int quantity, double paymentAmount) {
        int availableStock = inventoryManager.getStock(product);
        if (availableStock >= quantity) {
            double totalPrice = product.getPrice() * quantity;
            if (paymentStrategy.pay(paymentAmount)) {
                inventoryManager.removeProduct(product, quantity);
                System.out.println("Dispensing " + quantity + " " + product.getName() + "s. Change: $" + (paymentAmount - totalPrice));
            } else {
                System.out.println("Payment processing failed. Transaction canceled.");
            }
        } else {
            System.out.println("Insufficient stock for " + product.getName());
        }
    }
}






