package com.hs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Hotel {
	private final String name;
	private final List<Room> rooms = new ArrayList<>();

	public Hotel(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public void addRoom(Room room) {
		rooms.add(room);
	}

	public Optional<Room> findAvailableRoom(RoomType type, LocalDate checkIn, LocalDate checkOut) {
		return rooms.stream()
				.filter(r -> r.type() == type)
				.filter(r -> isAvailable(r, checkIn, checkOut))
				.findFirst();
	}

	private boolean isAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
		return room.bookings().stream().noneMatch(b -> b.overlaps(checkIn, checkOut));
	}

	public Optional<Booking> book(Guest guest, RoomType type, LocalDate checkIn, LocalDate checkOut) {
		Optional<Room> room = findAvailableRoom(type, checkIn, checkOut);
		if (room.isEmpty()) {
			System.out.println("No " + type + " room available for " + checkIn + " - " + checkOut);
			return Optional.empty();
		}
		Booking booking = new Booking(UUID.randomUUID().toString(), guest, room.get(), checkIn, checkOut);
		room.get().bookings().add(booking);
		System.out.println("Booked at " + name + ": " + booking);
		return Optional.of(booking);
	}

	public void cancel(String bookingId) {
		for (Room room : rooms) {
			room.bookings().removeIf(b -> {
				if (b.id().equals(bookingId)) {
					System.out.println("Cancelled: " + b);
					return true;
				}
				return false;
			});
		}
	}
}
