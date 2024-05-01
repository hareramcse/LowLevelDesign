package com.hs;

class GreenSignalState implements TrafficSignalState {
    @Override
    public void displayState() {
        System.out.println("Green Signal: Go");
    }

    @Override
    public void nextState(TrafficSignalSystem controller) {
        System.out.println("Switching to Yellow Signal");
        controller.setState(new YellowSignalState());
    }
}
