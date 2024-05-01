package com.hs;

import com.hs.payment.CardPaymentStrategy;
import com.hs.payment.PaymentStrategy;

public class Main {
	public static void main(String[] args) {
	    // Create inventory manager
	    InventoryManager inventoryManager = new SimpleInventoryManager();

	    // Add products to inventory
	    Snack chips = new Snack("Chips", 1.5);
	    inventoryManager.addProduct(chips, 10);

	    Snack soda = new Snack("Soda", 2.0);
	    inventoryManager.addProduct(soda, 5);

	    // Debug: Print stock before purchase
	    System.out.println("Stock before purchase: Chips - " + inventoryManager.getStock(chips));
	    System.out.println("Stock before purchase: Soda - " + inventoryManager.getStock(soda));

	    // Register observer for logging inventory changes
	    inventoryManager.registerObserver(new InventoryLogger());

	    // Create payment strategy (e.g., CardPaymentStrategy or CashPaymentStrategy)
	    PaymentStrategy paymentStrategy = new CardPaymentStrategy();

	    // Create vending machine with the inventory manager and payment strategy
	    VendingMachine vendingMachine = new VendingMachine(inventoryManager, paymentStrategy);

	    // Example usage
	    vendingMachine.processPurchase(chips, 2, 3.0); // This should succeed if there's sufficient stock

	    vendingMachine.processPurchase(soda, 1, 2.0);

	    // Debug: Print stock after purchase
	    System.out.println("Stock after purchase: Chips - " + inventoryManager.getStock(chips));
	    System.out.println("Stock after purchase: Soda - " + inventoryManager.getStock(soda));
	}

}
