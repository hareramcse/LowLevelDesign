package com.hs;

import com.hs.payement.CreditCardPayment;
import com.hs.payement.PaymentMethod;
import com.hs.strategy.DailyRentalStrategy;

public class Main {
	public static void main(String[] args) {
		// Create a rental system instance
		RentalSystem rentalSystem = RentalSystem.getInstance();

		// Add vehicles using factory methods
		rentalSystem.addCar(1, "Toyota Camry", 50.0);
		rentalSystem.addMotorcycle(2, "Honda CBR", 30.0);

		// Add customers
		Customer customer1 = new Customer(101, "John Doe", "123-456-7890");
		rentalSystem.addCustomer(customer1);

		// Create payment methods
		PaymentMethod creditCardPayment = new CreditCardPayment("1234 5678 9012 3456", "12/25", "123");

		// Rent a vehicle with credit card payment
		rentalSystem.rentVehicle(1, 101, 5, new DailyRentalStrategy(50.0), creditCardPayment);

		// Display vehicle and customer information
		rentalSystem.displayVehicleInformation();
		rentalSystem.displayCustomerInformation();

		// Return the vehicle
		rentalSystem.returnVehicle(101);

		// Display updated customer information
		rentalSystem.displayCustomerInformation();
	}
}
