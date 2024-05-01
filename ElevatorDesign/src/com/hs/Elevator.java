package com.hs;

public class Elevator {
	private int currentFloor;
	private Direction currentDirection;
	private boolean available;

	public Elevator() {
		this.currentFloor = 0;
		this.currentDirection = Direction.STOPPED;
		this.available = true;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void moveElevator(int targetFloor) {
		if (targetFloor > currentFloor) {
			currentDirection = Direction.UP;
		} else if (targetFloor < currentFloor) {
			currentDirection = Direction.DOWN;
		} else {
			currentDirection = Direction.STOPPED;
		}

		System.out.println("Elevator moving from floor " + currentFloor + " to floor " + targetFloor);
		currentFloor = targetFloor;
		System.out.println("Elevator reached floor " + currentFloor);
		ElevatorSystem.getInstance().elevatorArrived(this);
	}
}