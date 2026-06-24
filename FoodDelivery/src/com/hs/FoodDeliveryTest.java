package com.hs;

import java.util.List;

public class FoodDeliveryTest {
	public static void main(String[] args) {
		FoodDeliveryService service = FoodDeliveryService.getInstance();

		Restaurant restaurant = new Restaurant("r1", "Pizza Palace");
		restaurant.addMenuItem(new MenuItem("Margherita", 12.99));
		restaurant.addMenuItem(new MenuItem("Pepperoni", 14.99));
		service.registerRestaurant(restaurant);

		Customer customer = new Customer("c1", "John");
		Order order = service.placeOrder(customer, "r1",
				List.of(new MenuItem("Margherita", 12.99), new MenuItem("Pepperoni", 14.99)));

		if (order != null) {
			service.updateOrderStatus(order.id(), OrderStatus.CONFIRMED);
			service.updateOrderStatus(order.id(), OrderStatus.PREPARING);
			service.updateOrderStatus(order.id(), OrderStatus.OUT_FOR_DELIVERY);
			service.updateOrderStatus(order.id(), OrderStatus.DELIVERED);
		}
	}
}
