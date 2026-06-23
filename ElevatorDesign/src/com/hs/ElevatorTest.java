package com.hs;

public class ElevatorTest {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem();
        system.addElevator(new Elevator());
        system.addElevator(new Elevator());

        system.requestElevator(5, Direction.UP);
        system.requestElevator(3, Direction.DOWN);
    }
}
