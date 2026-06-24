package com.hs;

public class ParkingSpot {
	private final int spotNumber;
	private final int floorNumber;
	private final SpotType type;
	private boolean occupied;

	public ParkingSpot(int spotNumber, int floorNumber, SpotType type) {
		this.spotNumber = spotNumber;
		this.floorNumber = floorNumber;
		this.type = type;
	}

	public int spotNumber() {
		return spotNumber;
	}

	public int floorNumber() {
		return floorNumber;
	}

	public SpotType type() {
		return type;
	}

	public boolean isOccupied() {
		return occupied;
	}

	void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	static boolean canFit(VehicleType vehicle, SpotType spot) {
		return switch (vehicle) {
			case MOTORCYCLE -> true;
			case CAR -> spot == SpotType.COMPACT || spot == SpotType.LARGE;
			case TRUCK -> spot == SpotType.LARGE;
		};
	}

	@Override
	public String toString() {
		return "F" + floorNumber + "-S" + spotNumber + "(" + type + ")";
	}
}
