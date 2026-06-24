package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private final int roomNumber;
	private final RoomType type;
	private final List<Booking> bookings = new ArrayList<>();

	public Room(int roomNumber, RoomType type) {
		this.roomNumber = roomNumber;
		this.type = type;
	}

	public int roomNumber() {
		return roomNumber;
	}

	public RoomType type() {
		return type;
	}

	public List<Booking> bookings() {
		return bookings;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + " (" + type + ")";
	}
}
