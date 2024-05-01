package com.hs;

public class ParkingSlot {
    private int slotNumber;
    private boolean available;
    private boolean occupied; // Track if slot is currently occupied
    private int size; // Size of the slot in terms of vehicle size it can accommodate

    public ParkingSlot(int slotNumber, int size) {
        this.slotNumber = slotNumber;
        this.available = true;
        this.occupied = false;
        this.size = size;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getSize() {
        return size;
    }

	@Override
	public String toString() {
		return "ParkingSlot [slotNumber=" + slotNumber + "]";
	}
    
}