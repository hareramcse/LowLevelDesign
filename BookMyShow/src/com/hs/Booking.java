package com.hs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Booking implements Subject {
	private String bookingId;
	private User user;
	private Movie movie;
	private Theater theater;
	private LocalDateTime showTime;
	private List<Seat> seats;
	private Payment payment;
	private List<Observer> observers = new ArrayList<Observer>();

	public Booking(String bookingId, User user, Movie movie, Theater theater, LocalDateTime showTime,
			List<Seat> seats) {
		this.bookingId = bookingId;
		this.user = user;
		this.movie = movie;
		this.theater = theater;
		this.showTime = showTime;
		this.seats = seats;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user.getName() + ", movie=" + movie.getTitle()
				+ ", theater=" + theater.getName() + ", showTime=" + showTime + ", seats=" + seats.toString()
				+ ", payment=" + payment.getPaymentId() + "]";
	}

	public boolean bookSeats(List<Seat> selectedSeats) {
		// Step 1: Check Seat Availability
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
		// Placeholder method for calculating total price
		double basePricePerSeat = 10.0; // Assume base price per seat is $10
		double totalPrice = selectedSeats.size() * basePricePerSeat;
		// Additional logic for taxes, discounts, etc. can be added here
		return totalPrice;
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

	public void makePayment(PaymentMethod paymentMethod, double amount) {
		this.payment = new Payment(UUID.randomUUID().toString(), this, paymentMethod, amount);
		notifyObservers("Payment successful");
	}
}