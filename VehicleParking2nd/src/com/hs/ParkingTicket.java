package com.hs;

import java.util.Date;
import java.util.List;

public class ParkingTicket {
    private Vehicle vehicle;
    private List<ParkingSlot> parkingSlots;
    private Date entryTime;

    public ParkingTicket(Vehicle vehicle, List<ParkingSlot> parkingSlots) {
        this.vehicle = vehicle;
        this.parkingSlots = parkingSlots;
        this.entryTime = new Date(); // Set entry time to current time
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public Date getEntryTime() {
        return entryTime;
    }
}