package com.hs;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Inventory {
	private final Map<String, Product> catalog = new HashMap<>();
	private final Map<String, Integer> quantities = new HashMap<>();

	public void addProduct(Product product, int quantity) {
		catalog.put(product.code(), product);
		quantities.put(product.code(), quantity);
	}

	public Optional<Product> findByCode(String code) {
		return Optional.ofNullable(catalog.get(code));
	}

	public boolean isAvailable(Product product) {
		return quantities.getOrDefault(product.code(), 0) > 0;
	}

	public int getQuantity(Product product) {
		return quantities.getOrDefault(product.code(), 0);
	}

	synchronized void decrement(Product product) {
		int qty = quantities.getOrDefault(product.code(), 0);
		if (qty <= 0) {
			throw new IllegalStateException("Out of stock: " + product.name());
		}
		quantities.put(product.code(), qty - 1);
	}
}
