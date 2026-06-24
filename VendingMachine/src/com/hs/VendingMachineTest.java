package com.hs;

public class VendingMachineTest {
	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();

		Product coke = new Product("A1", "Coke", 1.50);
		Product pepsi = new Product("A2", "Pepsi", 1.50);
		Product water = new Product("B1", "Water", 1.00);

		machine.inventory().addProduct(coke, 3);
		machine.inventory().addProduct(pepsi, 2);
		machine.inventory().addProduct(water, 1);

		// Float for making change
		machine.cashInventory().stockCoins(Coin.QUARTER, 10);
		machine.cashInventory().stockCoins(Coin.DIME, 10);
		machine.cashInventory().stockCoins(Coin.NICKEL, 10);
		machine.cashInventory().stockCoins(Coin.PENNY, 10);

		System.out.println("--- Happy path with change ---");
		machine.selectProduct("A1");
		machine.insertNote(Note.FIVE);
		machine.dispenseProduct();
		machine.returnChange();

		System.out.println("\n--- Insufficient payment then cancel ---");
		machine.selectProduct("A2");
		machine.insertCoin(Coin.QUARTER);
		machine.cancel();

		System.out.println("\n--- Exact payment ---");
		machine.selectProduct("B1");
		machine.insertCoin(Coin.QUARTER);
		machine.insertCoin(Coin.QUARTER);
		machine.insertCoin(Coin.QUARTER);
		machine.insertCoin(Coin.QUARTER);
		machine.dispenseProduct();
		machine.returnChange();

		System.out.println("\n--- Out of stock ---");
		machine.selectProduct("B1");
		machine.selectProduct("B1");

		System.out.println("\n--- Unknown product ---");
		machine.selectProduct("Z9");
	}
}
