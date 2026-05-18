package com.hs;

public class ElevatorTest {
	public static void main(String[] args) {
		ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();

		Elevator elevator1 = new Elevator();
		Elevator elevator2 = new Elevator();
		elevatorSystem.addElevator(elevator1);
		elevatorSystem.addElevator(elevator2);

		elevatorSystem.requestElevator(5, Direction.UP);
		elevatorSystem.requestElevator(3, Direction.DOWN);
	}
}
