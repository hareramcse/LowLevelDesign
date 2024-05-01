package com.hs.factory;

public abstract class Vehicle {
	private int vehicleID;
	private String type;
	private String model;
	private boolean available;
	private double rentalCostPerDay;

	public Vehicle(int vehicleID, String type, String model, double rentalCostPerDay) {
		this.vehicleID = vehicleID;
		this.type = type;
		this.model = model;
		this.rentalCostPerDay = rentalCostPerDay;
		this.available = true; // Initially, the vehicle is available
	}

	public void rentVehicle() {
		if (available) {
			available = false; // Set availability to false when rented
		} else {
			System.out.println("Vehicle is not available for rent.");
		}
	}

	public void returnVehicle() {
		available = true; // Set availability to true when returned
	}

	public String toString() {
		return "Vehicle ID: " + vehicleID + ", Type: " + type + ", Model: " + model + ", Rental Cost Per Day: "
				+ rentalCostPerDay + ", Availability: " + (available ? "Available" : "Rented");
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public double getRentalCostPerDay() {
		return rentalCostPerDay;
	}

	public void setRentalCostPerDay(double rentalCostPerDay) {
		this.rentalCostPerDay = rentalCostPerDay;
	}

}
