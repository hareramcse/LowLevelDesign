package com.hs;

import java.time.Duration;
import java.time.Instant;

public class FixedWindowRateLimiter {
    private final int limit;
    private final Duration window;
    private int count;
    private Instant windowStart = Instant.now();

    public FixedWindowRateLimiter(int limit, Duration window) {
        this.limit = limit;
        this.window = window;
    }

    public synchronized boolean allowRequest(String clientId) {
        Instant now = Instant.now();
        if (now.isAfter(windowStart.plus(window))) {
            count = 0;
            windowStart = now;
        }
        if (count < limit) {
            count++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, Duration.ofSeconds(10));
        for (int i = 0; i < 10; i++) {
            System.out.println(limiter.allowRequest("client1") ? "Allowed" : "Denied");
        }
    }
}
