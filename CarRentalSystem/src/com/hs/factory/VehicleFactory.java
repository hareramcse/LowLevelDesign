package com.hs.factory;

public interface VehicleFactory {
	Vehicle createVehicle(int vehicleID, String model, double rentalCostPerDay);
}
