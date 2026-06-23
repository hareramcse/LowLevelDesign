package com.hs;

public class ParkingSlot {
	private final int slotNumber;
	private boolean occupied;

	public ParkingSlot(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public String toString() {
		return "ParkingSlot [slotNumber=" + slotNumber + "]";
	}
}
