package com.hs;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookMyShow {
	public static void main(String[] args) {
		User user = new User("U1", "John Doe", "john@example.com", "+1234567890");
		TheaterAdmin admin = new TheaterAdmin();
		Theater theater = admin.getTheater();

		// Create booking
		Booking booking = new Booking(UUID.randomUUID().toString(), user, theater.getMovies().get(0), theater,
				LocalDateTime.now(), theater.getAvailableSeats());
		UserObserver userObserver = new UserObserver(user);
		booking.registerObserver(userObserver);

		boolean bookable = booking.bookSeats(theater.getAvailableSeats());

		if (bookable) {
			// Make payment
			double amount = booking.calculateTotalPrice(theater.getAvailableSeats());
			booking.makePayment(PaymentMethod.CREDIT_CARD, amount);
			booking.notifyObservers(booking.toString());
		}
	}
}