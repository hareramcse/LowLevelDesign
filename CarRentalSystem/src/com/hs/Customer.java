package com.hs;

import com.hs.payement.PaymentMethod;

public class Customer {
	private final int customerID;
	private final String name;
	private final String phoneNumber;
	private Vehicle rentedVehicle;

	public Customer(int customerID, String name, String phoneNumber) {
		this.customerID = customerID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void rentVehicle(Vehicle vehicle, double rentalCost, PaymentMethod paymentMethod) {
		if (!vehicle.isAvailable()) {
			System.out.println("Selected vehicle is not available for rent.");
			return;
		}
		vehicle.rentVehicle();
		rentedVehicle = vehicle;
		paymentMethod.processPayment(rentalCost);
		System.out.println("Vehicle rented successfully.");
	}

	public void returnVehicle() {
		if (rentedVehicle == null) {
			System.out.println("No vehicle rented.");
			return;
		}
		rentedVehicle.returnVehicle();
		rentedVehicle = null;
		System.out.println("Vehicle returned successfully.");
	}

	public int getCustomerID() {
		return customerID;
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerID + ", Name: " + name + ", Phone Number: " + phoneNumber
				+ (rentedVehicle != null ? ", Rented Vehicle: " + rentedVehicle.getVehicleID() : "");
	}
}
