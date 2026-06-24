package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
	private final String id;
	private final Customer customer;
	private final Restaurant restaurant;
	private final List<MenuItem> items;
	private OrderStatus status = OrderStatus.PLACED;
	private final List<Observer> observers = new ArrayList<>();

	public Order(Customer customer, Restaurant restaurant, List<MenuItem> items) {
		this.id = UUID.randomUUID().toString();
		this.customer = customer;
		this.restaurant = restaurant;
		this.items = items;
		registerObserver(customer);
	}

	public String id() {
		return id;
	}

	public OrderStatus status() {
		return status;
	}

	public double totalAmount() {
		return items.stream().mapToDouble(MenuItem::price).sum();
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	void setStatus(OrderStatus status) {
		this.status = status;
		String message = "Order " + id + " from " + restaurant.name() + " is now " + status;
		observers.forEach(o -> o.update(message));
	}

	@Override
	public String toString() {
		return "Order " + id + " [" + restaurant.name() + "] $" + totalAmount() + " - " + status;
	}
}
