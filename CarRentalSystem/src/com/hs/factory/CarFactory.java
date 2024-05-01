package com.hs.factory;

public class CarFactory implements VehicleFactory {
	@Override
    public Vehicle createVehicle(int vehicleID, String model, double rentalCostPerDay) {
        return new Car(vehicleID, "Car", model, rentalCostPerDay);
    }
}
