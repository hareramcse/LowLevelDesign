package com.hs;

public class Main {
	public static void main(String[] args) {
		TrafficSignalSystem controller = new TrafficSignalSystem();

		controller.displayCurrentState(); // Outputs: Red Signal: Stop

		controller.switchToNextState(); // Outputs: Switching to Green Signal
		controller.displayCurrentState(); // Outputs: Green Signal: Go

		controller.switchToNextState(); // Outputs: Switching to Yellow Signal
		controller.displayCurrentState(); // Outputs: Yellow Signal: Prepare to Stop

		controller.switchToNextState(); // Outputs: Switching to Red Signal
		controller.displayCurrentState(); // Outputs: Red Signal: Stop
	}
}
