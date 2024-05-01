package com.hs;

class ProductFactory {
	public static Product createProduct(String type) {
		switch (type) {
		case "Snack":
			return new Snack("Chips", 1.5);
		case "Drink":
			return new Snack("Soda", 2.0);
		default:
			throw new IllegalArgumentException("Invalid product type: " + type);
		}
	}
}
