package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hs.payement.PaymentMethod;
import com.hs.strategy.PricingStrategy;

public class RentalSystem {
	private static RentalSystem instance;
	private final List<Vehicle> vehicleList = new ArrayList<>();
	private final List<Customer> customerList = new ArrayList<>();

	private RentalSystem() {
	}

	public static synchronized RentalSystem getInstance() {
		if (instance == null) {
			instance = new RentalSystem();
		}
		return instance;
	}

	public void addCar(int vehicleID, String model, double rentalCostPerDay) {
		addVehicle(VehicleType.CAR, vehicleID, model, rentalCostPerDay);
	}

	public void addMotorcycle(int vehicleID, String model, double rentalCostPerDay) {
		addVehicle(VehicleType.MOTORCYCLE, vehicleID, model, rentalCostPerDay);
	}

	private void addVehicle(VehicleType type, int vehicleID, String model, double rentalCostPerDay) {
		vehicleList.add(type.createVehicle(vehicleID, model, rentalCostPerDay));
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public void rentVehicle(int vehicleID, int customerID, int days, PricingStrategy pricingStrategy,
			PaymentMethod paymentMethod) {
		Optional<Vehicle> vehicle = vehicleList.stream()
				.filter(v -> v.getVehicleID() == vehicleID && v.isAvailable()).findFirst();
		Optional<Customer> customer = customerList.stream().filter(c -> c.getCustomerID() == customerID).findFirst();

		if (vehicle.isPresent() && customer.isPresent()) {
			double rentalCost = pricingStrategy.calculateRentalCost(days);
			customer.get().rentVehicle(vehicle.get(), rentalCost, paymentMethod);
		} else {
			System.out.println("Invalid vehicle ID or customer ID.");
		}
	}

	public void returnVehicle(int customerID) {
		customerList.stream().filter(c -> c.getCustomerID() == customerID).findFirst()
				.ifPresentOrElse(Customer::returnVehicle, () -> System.out.println("Invalid customer ID."));
	}

	public void displayVehicleInformation() {
		System.out.println("Vehicle Information:");
		vehicleList.forEach(v -> System.out.println(v));
	}

	public void displayCustomerInformation() {
		System.out.println("Customer Information:");
		customerList.forEach(c -> System.out.println(c));
	}
}
