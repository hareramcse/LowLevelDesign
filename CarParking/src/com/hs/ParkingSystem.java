package com.hs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSystem {
	private static ParkingSystem instance;
	private final List<ParkingSlot> slots = new ArrayList<>();
	private final Map<String, ParkingTicket> ticketMap = new HashMap<>();

	private ParkingSystem(int numSlots) {
		for (int i = 1; i <= numSlots; i++) {
			slots.add(new ParkingSlot(i));
		}
	}

	public static ParkingSystem getInstance(int numSlots) {
		if (instance == null) {
			instance = new ParkingSystem(numSlots);
		}
		return instance;
	}

	public ParkingTicket parkVehicle(Vehicle vehicle) {
		List<ParkingSlot> availableSlots = findAvailableSlots(vehicle.size());
		System.out.println("Available slots for vehicle " + vehicle.licensePlate() + ": " + availableSlots.size());
		if (availableSlots.isEmpty()) {
			return null;
		}
		availableSlots.forEach(slot -> slot.setOccupied(true));
		ParkingTicket ticket = new ParkingTicket(vehicle, availableSlots);
		ticketMap.put(vehicle.licensePlate(), ticket);
		return ticket;
	}

	public Vehicle retrieveVehicle(String licensePlate) {
		ParkingTicket ticket = ticketMap.remove(licensePlate);
		if (ticket == null) {
			return null;
		}
		ticket.getParkingSlots().forEach(slot -> slot.setOccupied(false));
		return ticket.getVehicle();
	}

	private List<ParkingSlot> findAvailableSlots(int requiredSize) {
		List<ParkingSlot> availableSlots = new ArrayList<>();
		for (ParkingSlot slot : slots) {
			if (!slot.isOccupied()) {
				availableSlots.add(slot);
				if (availableSlots.size() >= requiredSize) {
					return availableSlots;
				}
			}
		}
		return Collections.emptyList();
	}
}
