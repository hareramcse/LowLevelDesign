package com.hs;

public enum VehicleType {
	CAR("Car"),
	MOTORCYCLE("Motorcycle");

	private final String displayName;

	VehicleType(String displayName) {
		this.displayName = displayName;
	}

	public Vehicle createVehicle(int vehicleID, String model, double rentalCostPerDay) {
		return new Vehicle(vehicleID, this, model, rentalCostPerDay);
	}

	public String getDisplayName() {
		return displayName;
	}
}
