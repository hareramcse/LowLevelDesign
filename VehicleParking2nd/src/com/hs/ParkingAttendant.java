package com.hs;

public class ParkingAttendant {
	private ParkingSystem parkingSystem;

	public ParkingAttendant(ParkingSystem parkingSystem) {
		this.parkingSystem = parkingSystem;
	}

	public ParkingTicket parkVehicle(Vehicle vehicle) {
		return parkingSystem.parkVehicle(vehicle);
	}

	public Vehicle retrieveVehicle(String licensePlate) {
		return parkingSystem.retrieveVehicle(licensePlate);
	}
}
