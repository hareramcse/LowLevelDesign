package com.hs;

public class SlidingWindowCounterRateLimiter {
    private final int windowSizeMs;
    private final int requestLimit;
    private final int[] counts;
    private long windowStart;

    public SlidingWindowCounterRateLimiter(int windowSizeMs, int requestLimit) {
        this.windowSizeMs = windowSizeMs;
        this.requestLimit = requestLimit;
        this.counts = new int[windowSizeMs / 1000];
        this.windowStart = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStart >= windowSizeMs) {
            for (int i = 0; i < counts.length; i++) counts[i] = 0;
            windowStart = now;
        }
        int slot = (int) ((now / 1000) % counts.length);
        return ++counts[slot] <= requestLimit;
    }

    public static void main(String[] args) throws InterruptedException {
        SlidingWindowCounterRateLimiter limiter = new SlidingWindowCounterRateLimiter(1000, 10);
        for (int i = 0; i < 15; i++) {
            System.out.println("Request " + (i + 1) + ": " + (limiter.allowRequest() ? "Allowed" : "Denied"));
            Thread.sleep(50);
        }
    }
}
