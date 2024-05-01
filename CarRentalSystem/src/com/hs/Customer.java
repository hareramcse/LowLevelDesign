package com.hs;

import com.hs.factory.Vehicle;
import com.hs.payement.PaymentMethod;

public class Customer {
	private int customerID;
	private String name;
	private String phoneNumber;
	private Vehicle rentedVehicle;
	private double rentalCost;

	public Customer(int customerID, String name, String phoneNumber) {
		this.customerID = customerID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public void rentVehicle(Vehicle vehicle, double rentalCost, PaymentMethod paymentMethod) {
		if (vehicle.isAvailable()) {
			vehicle.rentVehicle();
			rentedVehicle = vehicle;
			this.rentalCost = rentalCost;
			paymentMethod.processPayment(rentalCost);
			System.out.println("Vehicle rented successfully.");
		} else {
			System.out.println("Selected vehicle is not available for rent.");
		}
	}

	public void returnVehicle() {
		if (rentedVehicle != null) {
			rentedVehicle.returnVehicle();
			rentedVehicle = null;
			System.out.println("Vehicle returned successfully.");
		} else {
			System.out.println("No vehicle rented.");
		}
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerID + ", Name: " + name + ", Phone Number: " + phoneNumber
				+ (rentedVehicle != null ? ", Rented Vehicle: " + rentedVehicle.getVehicleID() : "");
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}

	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}

	public void setRentalCost(double rentalCost) {
		this.rentalCost = rentalCost;
	}

	public double getRentalCost() {
		return rentalCost;
	}
}
