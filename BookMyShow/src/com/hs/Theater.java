package com.hs;

import java.util.List;

public class Theater {
	private final String name;
	private List<Seat> availableSeats;

	public Theater(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAvailableSeats(List<Seat> availableSeats) {
		this.availableSeats = availableSeats;
	}

	public List<Seat> getAvailableSeats() {
		return availableSeats;
	}
}
