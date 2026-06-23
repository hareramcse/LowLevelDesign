package com.hs;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookMyShowTest {
	public static void main(String[] args) {
		BookMyShow bookMyShow = BookMyShow.getInstance();

		User user = new User("John Doe");

		Movie movie1 = new Movie("The Avengers");

		Theater theater1 = new Theater("PVR Cinemas");
		Seat seat1 = new Seat(UUID.randomUUID().toString(), SeatType.EXECUTIVE, false);
		Seat seat2 = new Seat(UUID.randomUUID().toString(), SeatType.VIP, false);
		Seat seat3 = new Seat(UUID.randomUUID().toString(), SeatType.REGULAR, false);
		theater1.setAvailableSeats(List.of(seat1, seat2, seat3));
		bookMyShow.addTheater(theater1);

		List<Seat> seatToBook = List.of(seat1, seat2);
		Booking booking = new Booking(UUID.randomUUID().toString(), user, movie1, theater1, seatToBook,
				LocalDateTime.now());
		booking.registerObserver(user);

		if (bookMyShow.bookSeats(booking, seatToBook)) {
			double amount = bookMyShow.calculateTotalPrice(seatToBook);
			Payment payment = bookMyShow.makePayment(PaymentMethod.CREDIT_CARD, amount);
			booking.notifyObservers("Payment successfull");
			booking.setPayment(payment);
			booking.notifyObservers(booking.toString());
		}
	}
}
