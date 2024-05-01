package com.hs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Subject {
	private String bookingId;
	private User user;
	private Movie movie;
	private Theater theater;
	private LocalDateTime showTime;
	private List<Seat> seats;
	private Payment payment;
	private List<Observer> observers = new ArrayList<Observer>();

	public Booking(String bookingId, User user, Movie movie, Theater theater, List<Seat> seats,
			LocalDateTime showTime) {
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
}