package com.hs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {
	private final String bookingId;
	private final User user;
	private final Movie movie;
	private final Theater theater;
	private final LocalDateTime showTime;
	private final List<Seat> seats;
	private Payment payment;
	private final List<Observer> observers = new ArrayList<>();

	public Booking(String bookingId, User user, Movie movie, Theater theater, List<Seat> seats,
			LocalDateTime showTime) {
		this.bookingId = bookingId;
		this.user = user;
		this.movie = movie;
		this.theater = theater;
		this.showTime = showTime;
		this.seats = seats;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers(String message) {
		for (Observer observer : observers) {
			observer.update(message);
		}
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user.getName() + ", movie=" + movie.getTitle()
				+ ", theater=" + theater.getName() + ", showTime=" + showTime + ", seats=" + seats + ", payment="
				+ payment.getPaymentId() + "]";
	}
}
