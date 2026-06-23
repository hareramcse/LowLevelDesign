package com.hs;

public class Vehicle {
	private final int vehicleID;
	private final VehicleType type;
	private final String model;
	private final double rentalCostPerDay;
	private boolean available = true;

	public Vehicle(int vehicleID, VehicleType type, String model, double rentalCostPerDay) {
		this.vehicleID = vehicleID;
		this.type = type;
		this.model = model;
		this.rentalCostPerDay = rentalCostPerDay;
	}

	public void rentVehicle() {
		if (!available) {
			System.out.println("Vehicle is not available for rent.");
			return;
		}
		available = false;
	}

	public void returnVehicle() {
		available = true;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public boolean isAvailable() {
		return available;
	}

	@Override
	public String toString() {
		return "Vehicle ID: " + vehicleID + ", Type: " + type.getDisplayName() + ", Model: " + model
				+ ", Rental Cost Per Day: " + rentalCostPerDay + ", Availability: "
				+ (available ? "Available" : "Rented");
	}
}
