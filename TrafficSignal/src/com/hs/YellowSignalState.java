package com.hs;

class YellowSignalState implements TrafficSignalState {
    @Override
    public void displayState() {
        System.out.println("Yellow Signal: Prepare to Stop");
    }

    @Override
    public void nextState(TrafficSignalSystem controller) {
        System.out.println("Switching to Red Signal");
        controller.setState(new RedSignalState());
    }
}
