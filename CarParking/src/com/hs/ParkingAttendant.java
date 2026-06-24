package com.hs;

import java.util.Optional;

public class ParkingAttendant {
	private final ParkingLot parkingLot;

	public ParkingAttendant(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public Optional<ParkingTicket> parkVehicle(Vehicle vehicle) {
		return parkingLot.park(vehicle);
	}

	public Optional<ExitReceipt> exit(String ticketId) {
		return parkingLot.exit(ticketId);
	}

	public int availableSpots(int floorNumber, SpotType type) {
		return parkingLot.countAvailable(floorNumber, type);
	}
}
