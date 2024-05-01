package com.hs;

import java.util.List;

public class Theater {
	private String theaterId;
	private String name;
	private String location;
	private int totalSeats;
	private List<Movie> movies;
	private List<Seat> availableSeats;

	public Theater(String theaterId, String name, String location, int totalSeats) {
		this.theaterId = theaterId;
		this.name = name;
		this.location = location;
		this.totalSeats = totalSeats;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public void setAvailableSeats(List<Seat> availableSeats) {
		this.availableSeats = availableSeats;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}
