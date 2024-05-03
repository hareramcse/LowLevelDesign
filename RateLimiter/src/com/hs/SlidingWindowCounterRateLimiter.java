package com.hs;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class SlidingWindowCounterRateLimiter {
    private final int windowSizeInMillis;
    private final int requestLimit;
    private final AtomicInteger[] requestCounts;
    private final AtomicLong lastWindowResetTime;

    public SlidingWindowCounterRateLimiter(int windowSizeInMillis, int requestLimit) {
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestLimit = requestLimit;
        this.requestCounts = new AtomicInteger[windowSizeInMillis / 1000];
        for (int i = 0; i < requestCounts.length; i++) {
            requestCounts[i] = new AtomicInteger(0);
        }
        this.lastWindowResetTime = new AtomicLong(System.currentTimeMillis());
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        int currentSlot = (int) ((currentTime / 1000) % requestCounts.length);
        long lastReset = lastWindowResetTime.get();

        // Reset the window if necessary
        if (currentTime - lastReset >= windowSizeInMillis) {
            for (AtomicInteger count : requestCounts) {
                count.set(0); // Reset counts in all slots
            }
            lastWindowResetTime.set(currentTime);
        }

        // Increment the count for the current slot
        int currentCount = requestCounts[currentSlot].incrementAndGet();
        return currentCount <= requestLimit; // Allow request if count within limit
    }

    public static void main(String[] args) {
        SlidingWindowCounterRateLimiter rateLimiter = new SlidingWindowCounterRateLimiter(1000, 10); // 1 second window, 10 requests per window
        for (int i = 0; i < 100; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + (i + 1) + ": Allowed");
            } else {
                System.out.println("Request " + (i + 1) + ": Denied"); // Simulate denied request
            }
            try {
                Thread.sleep(1); // Simulate requests happening every milli seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}