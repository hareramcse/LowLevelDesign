package com.hs;

import java.time.LocalDate;

public class HotelBookingTest {
	public static void main(String[] args) {
		Hotel hotel = new Hotel("Grand Plaza");
		hotel.addRoom(new Room(101, RoomType.STANDARD));
		hotel.addRoom(new Room(201, RoomType.DELUXE));
		hotel.addRoom(new Room(301, RoomType.SUITE));

		Guest guest1 = new Guest("g1", "Alice");
		Guest guest2 = new Guest("g2", "Bob");

		hotel.book(guest1, RoomType.DELUXE, LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 4));
		hotel.book(guest2, RoomType.DELUXE, LocalDate.of(2026, 7, 2), LocalDate.of(2026, 7, 3)); // conflict
		hotel.book(guest2, RoomType.STANDARD, LocalDate.of(2026, 7, 5), LocalDate.of(2026, 7, 7));
	}
}
