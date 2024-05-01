package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private Queue<Request> requestQueue;
    private int currentFloor;
    
    private static ElevatorSystem instance;

    private ElevatorSystem() {
        this.elevators = new ArrayList<>();
        this.currentFloor = 0;
        this.requestQueue = new PriorityQueue<>();
    }

    public static synchronized ElevatorSystem getInstance() {
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void addElevator(Elevator elevator) {
        this.elevators.add(elevator);
    }

    public void requestElevator(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        requestQueue.add(request);
        processRequests();
    }

    private void processRequests() {
        while (!requestQueue.isEmpty()) {
            Request request = requestQueue.poll();
            Elevator selectedElevator = selectElevator(request.getFloor(), request.getDirection());
            if (selectedElevator != null) {
                selectedElevator.moveElevator(request.getFloor());
            }
        }
    }

    private Elevator selectElevator(int floor, Direction direction) {
        Elevator selectedElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if ((elevator.getCurrentDirection() == direction || elevator.getCurrentDirection() == Direction.STOPPED)
                    && elevator.isAvailable()) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    selectedElevator = elevator;
                }
            }
        }

        return selectedElevator;
    }

    public void elevatorArrived(Elevator elevator) {
        elevator.setAvailable(true);
    }
}
