package com.hs.factory;

public class MotorcycleFactory implements VehicleFactory {
	@Override
    public Vehicle createVehicle(int vehicleID, String model, double rentalCostPerDay) {
        return new Motorcycle(vehicleID, "Motorcycle", model, rentalCostPerDay);
    }
}
