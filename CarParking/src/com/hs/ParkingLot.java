package com.hs;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ParkingLot {
	private final List<Floor> floors;
	private final PricingStrategy pricingStrategy;
	private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

	public ParkingLot(List<Floor> floors, PricingStrategy pricingStrategy) {
		this.floors = floors;
		this.pricingStrategy = pricingStrategy;
	}

	public synchronized Optional<ParkingTicket> park(Vehicle vehicle) {
		for (Floor floor : floors) {
			Optional<List<ParkingSpot>> spots = floor.findAndReserve(vehicle);
			if (spots.isPresent()) {
				ParkingTicket ticket = new ParkingTicket(UUID.randomUUID().toString(), vehicle, spots.get(),
						LocalDateTime.now());
				activeTickets.put(ticket.ticketId(), ticket);
				return Optional.of(ticket);
			}
		}
		System.out.println("Lot full for " + vehicle.vehicleType() + " [" + vehicle.licensePlate() + "]");
		return Optional.empty();
	}

	public synchronized Optional<ExitReceipt> exit(String ticketId) {
		ParkingTicket ticket = activeTickets.remove(ticketId);
		if (ticket == null) {
			System.out.println("Invalid ticket: " + ticketId);
			return Optional.empty();
		}
		LocalDateTime exitTime = LocalDateTime.now();
		double fee = pricingStrategy.calculateFee(ticket.entryTime(), exitTime, ticket.vehicle().vehicleType());
		ticket.spots().forEach(s -> s.setOccupied(false));
		return Optional.of(new ExitReceipt(ticketId, fee, exitTime));
	}

	public int countAvailable(int floorNumber, SpotType type) {
		return floors.stream()
				.filter(f -> f.floorNumber() == floorNumber)
				.findFirst()
				.map(f -> f.countAvailable(type))
				.orElse(0);
	}
}
