package com.hs;

import java.time.Instant;

public class TokenBucketRateLimiter {
    private final int capacity;
    private final double refillRatePerSecond;
    private double tokens;
    private Instant lastRefill = Instant.now();

    public TokenBucketRateLimiter(int capacity, double refillRatePerSecond) {
        this.capacity = capacity;
        this.refillRatePerSecond = refillRatePerSecond;
        this.tokens = capacity;
    }

    public synchronized boolean tryConsume(double amount) {
        refill();
        if (tokens >= amount) {
            tokens -= amount;
            return true;
        }
        return false;
    }

    private void refill() {
        Instant now = Instant.now();
        double elapsed = (now.toEpochMilli() - lastRefill.toEpochMilli()) / 1000.0;
        tokens = Math.min(capacity, tokens + elapsed * refillRatePerSecond);
        lastRefill = now;
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 0.5);
        for (int i = 0; i < 15; i++) {
            System.out.println(limiter.tryConsume(1) ? "Allowed" : "Denied");
        }
    }
}
