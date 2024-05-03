package com.hs;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowRateLimiter {
	private final Map<String, Deque<Instant>> requestLog;
	private final int limit;
	private final Duration window;

	public SlidingWindowRateLimiter(int limit, Duration window) {
		this.limit = limit;
		this.window = window;
		this.requestLog = new HashMap<>();
	}

	public synchronized boolean allowRequest(String clientId) {
		Instant now = Instant.now();

		// Clean up old entries
		requestLog.entrySet().removeIf(
				entry -> entry.getValue().peek() != null && entry.getValue().peek().isBefore(now.minus(window)));

		// Get or create the client's request queue
		Deque<Instant> queue = requestLog.computeIfAbsent(clientId, k -> new ArrayDeque<>());

		// Add the current request timestamp
		queue.offer(now);

		// Check if the number of requests within the window exceeds the limit
		return queue.size() <= limit;
	}

	public static void main(String[] args) {
		// Limit 5 requests per 10 seconds
		SlidingWindowRateLimiter limiter = new SlidingWindowRateLimiter(5, Duration.ofSeconds(10));

		// Simulate client requests
		String clientId = "client1";
		for (int i = 0; i < 10; i++) {
			boolean allowed = limiter.allowRequest(clientId);
			if (allowed) {
				System.out.println("Request allowed");
			} else {
				System.out.println("Request blocked: Limit exceeded");
			}
		}
	}
}
