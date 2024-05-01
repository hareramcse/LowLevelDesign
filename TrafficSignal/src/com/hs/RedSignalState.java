package com.hs;

class RedSignalState implements TrafficSignalState {
    @Override
    public void displayState() {
        System.out.println("Red Signal: Stop");
    }

    @Override
    public void nextState(TrafficSignalSystem controller) {
        System.out.println("Switching to Green Signal");
        controller.setState(new GreenSignalState());
    }
}