package com.hs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleInventoryManager implements InventoryManager {
    private Map<Product, Integer> stock;
    private List<InventoryObserver> observers;

    public SimpleInventoryManager() {
        stock = new HashMap<>();
        observers = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
        notifyObservers(product, quantity);
    }

    @Override
    public void removeProduct(Product product, int quantity) {
        int currentStock = stock.getOrDefault(product, 0);
        if (currentStock >= quantity) {
            stock.put(product, currentStock - quantity);
        } else {
            System.out.println("Insufficient stock for " + product.getName());
        }
    }

    @Override
    public int getStock(Product product) {
        return stock.getOrDefault(product, 0);
    }

    @Override
    public void registerObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(InventoryObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Product product, int quantity) {
        for (InventoryObserver observer : observers) {
            observer.update(product, quantity);
        }
    }
}
