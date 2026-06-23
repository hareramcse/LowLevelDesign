package com.hs;

import java.util.ArrayList;
import java.util.List;

public class TrafficController {
    private final List<Road> roads = new ArrayList<>();

    public void addRoad(Road road) {
        roads.add(road);
    }

    public void startTrafficControl() {
        for (Road road : roads) {
            TrafficLight light = road.trafficLight();
            new Thread(() -> runCycle(light)).start();
        }
    }

    private void runCycle(TrafficLight light) {
        try {
            while (true) {
                Thread.sleep(light.redDuration());
                light.changeSignal(Signal.GREEN);
                Thread.sleep(light.greenDuration());
                light.changeSignal(Signal.YELLOW);
                Thread.sleep(light.yellowDuration());
                light.changeSignal(Signal.RED);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
