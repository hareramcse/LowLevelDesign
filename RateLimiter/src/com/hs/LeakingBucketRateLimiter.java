package com.hs;

import java.time.Instant;

public class LeakingBucketRateLimiter {
    private final int capacity;
    private final double leakRatePerSecond;
    private double water;
    private Instant lastLeak = Instant.now();

    public LeakingBucketRateLimiter(int capacity, double leakRatePerSecond) {
        this.capacity = capacity;
        this.leakRatePerSecond = leakRatePerSecond;
        this.water = 0;
    }

    public synchronized boolean tryConsume(double amount) {
        leak();
        if (water + amount <= capacity) {
            water += amount;
            return true;
        }
        return false;
    }

    private void leak() {
        Instant now = Instant.now();
        double elapsed = (now.toEpochMilli() - lastLeak.toEpochMilli()) / 1000.0;
        water = Math.max(0, water - elapsed * leakRatePerSecond);
        lastLeak = now;
    }

    public static void main(String[] args) {
        LeakingBucketRateLimiter limiter = new LeakingBucketRateLimiter(10, 0.5);
        for (int i = 0; i < 15; i++) {
            System.out.println(limiter.tryConsume(1) ? "Allowed" : "Denied");
        }
    }
}
