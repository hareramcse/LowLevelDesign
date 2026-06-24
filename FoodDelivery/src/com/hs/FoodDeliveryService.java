package com.hs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FoodDeliveryService {
	private static FoodDeliveryService instance;
	private final Map<String, Restaurant> restaurants = new HashMap<>();
	private final Map<String, Order> orders = new HashMap<>();

	private FoodDeliveryService() {
	}

	public static synchronized FoodDeliveryService getInstance() {
		if (instance == null) {
			instance = new FoodDeliveryService();
		}
		return instance;
	}

	public void registerRestaurant(Restaurant restaurant) {
		restaurants.put(restaurant.id(), restaurant);
	}

	public Optional<Restaurant> findRestaurant(String id) {
		return Optional.ofNullable(restaurants.get(id));
	}

	public Order placeOrder(Customer customer, String restaurantId, List<MenuItem> items) {
		Restaurant restaurant = restaurants.get(restaurantId);
		if (restaurant == null) {
			System.out.println("Restaurant not found.");
			return null;
		}
		Order order = new Order(customer, restaurant, new ArrayList<>(items));
		orders.put(order.id(), order);
		System.out.println("Placed: " + order);
		return order;
	}

	public void updateOrderStatus(String orderId, OrderStatus status) {
		Order order = orders.get(orderId);
		if (order != null) {
			order.setStatus(status);
		}
	}
}
