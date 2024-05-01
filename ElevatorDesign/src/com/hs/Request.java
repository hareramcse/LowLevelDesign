package com.hs;

public class Request implements Comparable<Request> {
	private int floor;
	private Direction direction;

	public Request(int floor, Direction direction) {
		this.floor = floor;
		this.direction = direction;
	}

	public int getFloor() {
		return floor;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public int compareTo(Request other) {
		// Implementing priority logic for requests
		if (this.direction == other.direction) {
			return Math.abs(this.floor - ElevatorSystem.getInstance().getCurrentFloor())
					- Math.abs(other.floor - ElevatorSystem.getInstance().getCurrentFloor());
		} else {
			return this.direction.compareTo(other.direction);
		}
	}
}
