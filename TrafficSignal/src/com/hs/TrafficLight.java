package com.hs;

public class TrafficLight {
	private final String id;
	private Signal currentSignal;
	private int redDuration;
	private int yellowDuration;
	private int greenDuration;

	public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
		this.id = id;
		this.redDuration = redDuration;
		this.yellowDuration = yellowDuration;
		this.greenDuration = greenDuration;
		this.currentSignal = Signal.RED;
	}

	public synchronized void changeSignal(Signal newSignal) {
		System.out.println("Changing signal to " + newSignal);
		currentSignal = newSignal;
	}

	public Signal getCurrentSignal() {
		return currentSignal;
	}

	public int getRedDuration() {
		return redDuration;
	}

	public void setRedDuration(int redDuration) {
		this.redDuration = redDuration;
	}

	public int getYellowDuration() {
		return yellowDuration;
	}

	public void setYellowDuration(int yellowDuration) {
		this.yellowDuration = yellowDuration;
	}

	public int getGreenDuration() {
		return greenDuration;
	}

	public void setGreenDuration(int greenDuration) {
		this.greenDuration = greenDuration;
	}
}