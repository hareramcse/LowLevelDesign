package com.hs;

public class Seat {
	private final String seatId;
	private final SeatType seatType;
	private boolean isBooked;

	public Seat(String seatId, SeatType seatType, boolean isBooked) {
		this.seatId = seatId;
		this.seatType = seatType;
		this.isBooked = isBooked;
	}

	public String getSeatId() {
		return seatId;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatType=" + seatType.name() + ", isBooked=" + isBooked + "]";
	}
}
