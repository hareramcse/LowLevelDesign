package com.hs;

import java.util.List;

public class ParkingTicketFactory {
    public static ParkingTicket createTicket(Vehicle vehicle, List<ParkingSlot> parkingSlots) {
        return new ParkingTicket(vehicle, parkingSlots);
    }
}