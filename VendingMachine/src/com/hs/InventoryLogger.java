package com.hs;

public class InventoryLogger implements InventoryObserver {
    @Override
    public void update(Product product, int quantity) {
        if (quantity > 0) {
            System.out.println("Added " + quantity + " " + product.getName() + "(s) to inventory.");
        } else {
            System.out.println("Removed " + (-quantity) + " " + product.getName() + "(s) from inventory.");
        }
    }
}
