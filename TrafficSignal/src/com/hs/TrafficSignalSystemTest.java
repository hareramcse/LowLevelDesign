package com.hs;

public class TrafficSignalSystemTest {
    public static void main(String[] args) throws InterruptedException {
        TrafficController controller = new TrafficController();

        controller.addRoad(new Road("R1", "Main Street",
                new TrafficLight("TL1", 2000, 1000, 3000)));
        controller.addRoad(new Road("R2", "Broadway",
                new TrafficLight("TL2", 2000, 1000, 3000)));

        controller.startTrafficControl();
        Thread.sleep(12000); // run demo for 12 seconds
    }
}
