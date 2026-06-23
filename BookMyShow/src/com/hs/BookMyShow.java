package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookMyShow {
	private List<Theater> theaters;
	private static BookMyShow instance;

	private BookMyShow() {
		theaters = new ArrayList<>();
	}

	public static synchronized BookMyShow getInstance() {
		if (instance == null) {
			instance = new BookMyShow();
		}
		return instance;
	}

	public void addTheater(Theater theater) {
		theaters.add(theater);
	}

	public Payment makePayment(PaymentMethod paymentMethod, double amount) {
		Payment payment = new Payment(UUID.randomUUID().toString(), paymentMethod, amount);
		// process payment
		return payment;
	}

	public boolean bookSeats(Booking booking, List<Seat> selectedSeats) {
		// Step 1: Check Seat Availability
		Theater theater = booking.getTheater();
		List<Seat> availableSeats = theater.getAvailableSeats();
		for (Seat seat : availableSeats) {
			if (seat.isBooked()) {
				System.out.println("Seat " + seat.getSeatId() + " is already booked.");
				return false;
			} else {
				for (Seat selectedSeat : selectedSeats) {
					if (seat.getSeatId().equals(selectedSeat.getSeatId())) {
						seat.setBooked(true);
					}
				}
			}
		}
		return true;
	}

	public double calculateTotalPrice(List<Seat> selectedSeats) {
		double basePricePerSeat = 10.0;
		return selectedSeats.size() * basePricePerSeat;
	}
}
