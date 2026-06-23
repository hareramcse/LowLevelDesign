package com.hs;

public class Elevator {
    private int currentFloor;
    private Direction direction = Direction.STOPPED;

    public int currentFloor() { return currentFloor; }
    public Direction direction() { return direction; }

    public void moveTo(int targetFloor) {
        direction = targetFloor > currentFloor ? Direction.UP
                : targetFloor < currentFloor ? Direction.DOWN : Direction.STOPPED;
        System.out.println("Elevator moving " + currentFloor + " -> " + targetFloor);
        currentFloor = targetFloor;
        direction = Direction.STOPPED;
        System.out.println("Elevator at floor " + currentFloor);
    }
}
