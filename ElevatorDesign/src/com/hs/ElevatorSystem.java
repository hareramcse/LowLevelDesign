package com.hs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ElevatorSystem {
    private final List<Elevator> elevators = new ArrayList<>();
    private final Queue<Request> requests = new LinkedList<>();

    public void addElevator(Elevator elevator) {
        elevators.add(elevator);
    }

    public void requestElevator(int floor, Direction direction) {
        requests.add(new Request(floor, direction));
        processRequests();
    }

    private void processRequests() {
        while (!requests.isEmpty()) {
            Request request = requests.poll();
            Elevator elevator = selectElevator(request.floor(), request.direction());
            if (elevator != null) {
                elevator.moveTo(request.floor());
            }
        }
    }

    private Elevator selectElevator(int floor, Direction direction) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            if (elevator.direction() == direction || elevator.direction() == Direction.STOPPED) {
                int distance = Math.abs(elevator.currentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    best = elevator;
                }
            }
        }
        return best;
    }
}
