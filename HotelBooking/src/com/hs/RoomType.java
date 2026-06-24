package com.hs;

public enum RoomType {
	STANDARD(100), DELUXE(200), SUITE(350);

	private final double pricePerNight;

	RoomType(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public double pricePerNight() {
		return pricePerNight;
	}
}
