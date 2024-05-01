package com.hs;

public interface InventoryManager {
	void addProduct(Product product, int quantity);
    void removeProduct(Product product, int quantity);
    int getStock(Product product);
    
    void registerObserver(InventoryObserver observer);
    void removeObserver(InventoryObserver observer);
    void notifyObservers(Product product, int quantity);
}
