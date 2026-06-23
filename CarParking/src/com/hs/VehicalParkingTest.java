package com.hs;

public class VehicalParkingTest {
	public static void main(String[] args) {
		ParkingSystem parkingSystem = ParkingSystem.getInstance(10);
		ParkingAttendant attendant = new ParkingAttendant(parkingSystem);

		Vehicle car = new Vehicle("ABC123", "Car", 2);
		Vehicle motorcycle = new Vehicle("XYZ789", "Motorcycle", 1);
		ParkingTicket carTicket = attendant.parkVehicle(car);
		ParkingTicket motorcycleTicket = attendant.parkVehicle(motorcycle);

		if (carTicket != null) {
			System.out.println("Car parked. Slots: " + carTicket.getParkingSlots());
		} else {
			System.out.println("No available slots for car.");
		}

		if (motorcycleTicket != null) {
			System.out.println("Motorcycle parked. Slots: " + motorcycleTicket.getParkingSlots());
		} else {
			System.out.println("No available slot for motorcycle.");
		}

		Vehicle retrievedCar = attendant.retrieveVehicle("ABC123");
		Vehicle retrievedMotorcycle = attendant.retrieveVehicle("XYZ789");

		if (retrievedCar != null) {
			System.out.println("Retrieved Car. License Plate: " + retrievedCar.licensePlate());
		} else {
			System.out.println("Car not found.");
		}

		if (retrievedMotorcycle != null) {
			System.out.println("Retrieved Motorcycle. License Plate: " + retrievedMotorcycle.licensePlate());
		} else {
			System.out.println("Motorcycle not found.");
		}
	}
}
