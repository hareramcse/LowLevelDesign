package com.hs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingSystem {
	private static ParkingSystem instance;
	private List<ParkingSlot> slots;
	private Map<String, ParkingTicket> ticketMap;

	private ParkingSystem(int numSlots) {
		slots = new ArrayList<>();
		ticketMap = new HashMap<>();
		initializeSlots(numSlots);
	}

	public static ParkingSystem getInstance(int numSlots) {
		if (instance == null) {
			instance = new ParkingSystem(numSlots);
		}
		return instance;
	}

	private void initializeSlots(int numSlots) {
		for (int i = 1; i <= numSlots; i++) {
			slots.add(new ParkingSlot(i, 1)); // Initialize all slots to accommodate one-slot vehicles initially
		}
	}

	public ParkingTicket parkVehicle(Vehicle vehicle) {
		List<ParkingSlot> availableSlots = findAvailableSlots(vehicle.getSize());
		System.out.println("Available slots for vehicle " + vehicle.getLicensePlate() + ": " + availableSlots.size());
		if (!availableSlots.isEmpty()) {
			for (ParkingSlot slot : availableSlots) {
				slot.setOccupied(true);
			}
			ParkingTicket ticket = ParkingTicketFactory.createTicket(vehicle, availableSlots);
			ticketMap.put(vehicle.getLicensePlate(), ticket);
			return ticket;
		}
		return null; // No available slots
	}

	public Vehicle retrieveVehicle(String licensePlate) {
		ParkingTicket ticket = ticketMap.get(licensePlate);
		if (ticket != null) {
			for (ParkingSlot slot : ticket.getParkingSlots()) {
				slot.setOccupied(false);
			}
			ticketMap.remove(licensePlate);
			return ticket.getVehicle();
		}
		return null; // Vehicle not found
	}

	private List<ParkingSlot> findAvailableSlots(int requiredSize) {
		List<ParkingSlot> availableSlots = new ArrayList<>();
		int count = 0;
		for (ParkingSlot slot : slots) {
			if (!slot.isOccupied()) {
				availableSlots.add(slot);
				count++;
				if (count >= requiredSize) {
					break;
				}
			}
		}
		return availableSlots.size() >= requiredSize ? availableSlots : Collections.emptyList();
	}
}