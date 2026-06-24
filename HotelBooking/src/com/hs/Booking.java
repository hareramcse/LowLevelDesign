package com.hs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
	private final String id;
	private final Guest guest;
	private final Room room;
	private final LocalDate checkIn;
	private final LocalDate checkOut;

	public Booking(String id, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
		this.id = id;
		this.guest = guest;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String id() {
		return id;
	}

	public Guest guest() {
		return guest;
	}

	public Room room() {
		return room;
	}

	public LocalDate checkIn() {
		return checkIn;
	}

	public LocalDate checkOut() {
		return checkOut;
	}

	public double totalPrice() {
		long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
		return nights * room.type().pricePerNight();
	}

	boolean overlaps(LocalDate in, LocalDate out) {
		return checkIn.isBefore(out) && in.isBefore(checkOut);
	}

	@Override
	public String toString() {
		return "Booking " + id + ": " + guest + " -> " + room + " [" + checkIn + " to " + checkOut + "] $"
				+ totalPrice();
	}
}
