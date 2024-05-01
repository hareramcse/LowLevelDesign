package com.hs;

class TrafficSignalSystem {
    private TrafficSignalState currentState;

    public TrafficSignalSystem() {
        this.currentState = new RedSignalState(); // Initial state
    }

    public void setState(TrafficSignalState state) {
        this.currentState = state;
    }

    public void displayCurrentState() {
        currentState.displayState();
    }

    public void switchToNextState() {
        currentState.nextState(this);
    }
}