package com.hs;

import java.util.List;

public class ParkingTicket {
	private final Vehicle vehicle;
	private final List<ParkingSlot> parkingSlots;

	public ParkingTicket(Vehicle vehicle, List<ParkingSlot> parkingSlots) {
		this.vehicle = vehicle;
		this.parkingSlots = parkingSlots;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public List<ParkingSlot> getParkingSlots() {
		return parkingSlots;
	}
}
