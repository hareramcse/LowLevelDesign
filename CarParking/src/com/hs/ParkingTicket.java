package com.hs;

import java.time.LocalDateTime;
import java.util.List;

public class ParkingTicket {
	private final String ticketId;
	private final Vehicle vehicle;
	private final List<ParkingSpot> spots;
	private final LocalDateTime entryTime;

	public ParkingTicket(String ticketId, Vehicle vehicle, List<ParkingSpot> spots, LocalDateTime entryTime) {
		this.ticketId = ticketId;
		this.vehicle = vehicle;
		this.spots = spots;
		this.entryTime = entryTime;
	}

	public String ticketId() {
		return ticketId;
	}

	public Vehicle vehicle() {
		return vehicle;
	}

	public List<ParkingSpot> spots() {
		return spots;
	}

	public LocalDateTime entryTime() {
		return entryTime;
	}

	@Override
	public String toString() {
		return "Ticket " + ticketId + " | " + vehicle.licensePlate() + " | spots=" + spots + " | entry=" + entryTime;
	}
}
