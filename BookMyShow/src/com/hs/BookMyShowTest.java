package com.hs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookMyShowTest {
	public static void main(String[] args) {
		BookMyShow bookMyShow = BookMyShow.getInstance();

		User user = new User("U1", "John Doe", "john@example.com", "+1234567890");
		User user1 = new User("1", "John Doe", "john@example.com", "+1234567890");
		bookMyShow.addUser(user1);

		Movie movie1 = new Movie("M1", "The Avengers", "Joss Whedon", Genre.ACTION);
		bookMyShow.addMovie(movie1);

		Theater theater1 = new Theater("T1", "PVR Cinemas", "Location 1", 100);
		Seat seat1 = new Seat(UUID.randomUUID().toString(), SeatType.EXECUTIVE, false);
		Seat seat2 = new Seat(UUID.randomUUID().toString(), SeatType.VIP, false);
		Seat seat3 = new Seat(UUID.randomUUID().toString(), SeatType.REGULAR, false);
		theater1.setAvailableSeats(List.of(seat1, seat2, seat3));
		theater1.setMovies(List.of(movie1));
		bookMyShow.addTheater(theater1);

		List<Seat> seatToBook = List.of(seat1, seat2);
		// Create booking
		Booking booking = new Booking(UUID.randomUUID().toString(), user, movie1, theater1, seatToBook,
				LocalDateTime.now());
		UserObserver userObserver = new UserObserver(user);
		booking.registerObserver(userObserver);

		boolean bookable = bookMyShow.bookSeats(booking, seatToBook);

		if (bookable) {
			// Make payment
			double amount = bookMyShow.calculateTotalPrice(seatToBook);
			Payment payment = bookMyShow.makePayment(PaymentMethod.CREDIT_CARD, amount);
			booking.notifyObservers("Payment successfull");
			booking.setPayment(payment);
			booking.notifyObservers(booking.toString());
		}
	}
}