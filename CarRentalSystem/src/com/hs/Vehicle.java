package com.hs;

public class Vehicle {
	private final int vehicleID;
	private final VehicleType type;
	private final String model;
	private final double rentalCostPerDay;

	public Vehicle(int vehicleID, VehicleType type, String model, double rentalCostPerDay) {
		this.vehicleID = vehicleID;
		this.type = type;
		this.model = model;
		this.rentalCostPerDay = rentalCostPerDay;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public VehicleType getType() {
		return type;
	}

	public double getRentalCostPerDay() {
		return rentalCostPerDay;
	}

	@Override
	public String toString() {
		return "Vehicle ID: " + vehicleID + ", Type: " + type.getDisplayName() + ", Model: " + model
				+ ", Rate/Day: $" + rentalCostPerDay;
	}
}
