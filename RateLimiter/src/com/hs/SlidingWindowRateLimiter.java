package com.hs;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowRateLimiter {
    private final int limit;
    private final Duration window;
    private final Map<String, Deque<Instant>> requestLog = new HashMap<>();

    public SlidingWindowRateLimiter(int limit, Duration window) {
        this.limit = limit;
        this.window = window;
    }

    public synchronized boolean allowRequest(String clientId) {
        Instant now = Instant.now();
        Deque<Instant> queue = requestLog.computeIfAbsent(clientId, k -> new ArrayDeque<>());
        while (!queue.isEmpty() && queue.peek().isBefore(now.minus(window))) {
            queue.poll();
        }
        if (queue.size() < limit) {
            queue.offer(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(5, Duration.ofSeconds(10));
        for (int i = 0; i < 10; i++) {
            System.out.println(limiter.allowRequest("client1") ? "Allowed" : "Denied");
        }
    }
}
