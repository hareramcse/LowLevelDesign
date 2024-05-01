package com.hs;

public interface TrafficSignalState {
	void displayState();
	void nextState(TrafficSignalSystem controller);
}
