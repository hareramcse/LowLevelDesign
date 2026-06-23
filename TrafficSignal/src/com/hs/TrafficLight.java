package com.hs;

public class TrafficLight {
    private final String id;
    private final int redDuration;
    private final int yellowDuration;
    private final int greenDuration;

    public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }

    public String id() { return id; }
    public int redDuration() { return redDuration; }
    public int yellowDuration() { return yellowDuration; }
    public int greenDuration() { return greenDuration; }

    public synchronized void changeSignal(Signal signal) {
        System.out.println(id + " -> " + signal);
    }
}
