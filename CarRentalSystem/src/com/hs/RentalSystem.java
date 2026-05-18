package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hs.factory.CarFactory;
import com.hs.factory.MotorcycleFactory;
import com.hs.factory.Vehicle;
import com.hs.factory.VehicleFactory;
import com.hs.payement.PaymentMethod;
import com.hs.strategy.PricingStrategy;

public class RentalSystem {
	private static RentalSystem instance;
	private List<Vehicle> vehicleList;
	private List<Customer> customerList;
	private VehicleFactory carFactory;
	private VehicleFactory motorcycleFactory;

	private RentalSystem() {
		vehicleList = new ArrayList<>();
		customerList = new ArrayList<>();
		carFactory = new CarFactory();
		motorcycleFactory = new MotorcycleFactory();
	}

	public static synchronized RentalSystem getInstance() {
		if (instance == null) {
			instance = new RentalSystem();
		}
		return instance;
	}

	public void addCar(int vehicleID, String model, double rentalCostPerDay) {
		Vehicle car = carFactory.createVehicle(vehicleID, model, rentalCostPerDay);
		vehicleList.add(car);
	}

	public void addMotorcycle(int vehicleID, String model, double rentalCostPerDay) {
		Vehicle motorcycle = motorcycleFactory.createVehicle(vehicleID, model, rentalCostPerDay);
		vehicleList.add(motorcycle);
	}

	public void removeVehicle(int vehicleID) {
		vehicleList.removeIf(vehicle -> vehicle.getVehicleID() == vehicleID);
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	public void removeCustomer(int customerID) {
		customerList.removeIf(customer -> customer.getCustomerID() == customerID);
	}

	public void rentVehicle(int vehicleID, int customerID, int days, PricingStrategy pricingStrategy,
			PaymentMethod paymentMethod) {
		Optional<Vehicle> optionalVehicle = vehicleList.stream()
				.filter(v -> v.getVehicleID() == vehicleID && v.isAvailable()).findFirst();

		Optional<Customer> optionalCustomer = customerList.stream().filter(c -> c.getCustomerID() == customerID)
				.findFirst();

		if (optionalVehicle.isPresent() && optionalCustomer.isPresent()) {
			Vehicle vehicle = optionalVehicle.get();
			Customer customer = optionalCustomer.get();
			double rentalCost = pricingStrategy.calculateRentalCost(days);
			customer.rentVehicle(vehicle, rentalCost, paymentMethod);
		} else {
			System.out.println("Invalid vehicle ID or customer ID.");
		}
	}

	public void returnVehicle(int customerID) {
		Optional<Customer> optionalCustomer = customerList.stream().filter(c -> c.getCustomerID() == customerID)
				.findFirst();

		if (optionalCustomer.isPresent()) {
			optionalCustomer.get().returnVehicle();
		} else {
			System.out.println("Invalid customer ID.");
		}
	}

	public void displayVehicleInformation() {
		System.out.println("Vehicle Information:");
		for (Vehicle vehicle : vehicleList) {
			System.out.println(vehicle.toString());
		}
	}

	public void displayCustomerInformation() {
		System.out.println("Customer Information:");
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}
	}
}
