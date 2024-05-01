package com.hs;

public class Seat {
	private String seatId;
	private SeatType seatType;
	private boolean isBooked;

	public Seat(String seatId, SeatType seatType, boolean isBooked) {
		this.seatId = seatId;
		this.seatType = seatType;
		this.isBooked = isBooked;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
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
