package com.hs;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter {
	private final Map<String, Instant> requestCounts;
	private final int limit;
	private final Duration window;

	public FixedWindowRateLimiter(int limit, Duration window) {
		this.limit = limit;
		this.window = window;
		this.requestCounts = new HashMap<>();
	}

	public synchronized boolean allowRequest(String clientId) {
		Instant now = Instant.now();
		Instant windowStart = now.minus(window);

		// Remove outdated entries
		requestCounts.entrySet().removeIf(entry -> entry.getValue().isBefore(windowStart));

		// Count current requests for the client
		int currentRequests = requestCounts.size();

		// Check if the limit is exceeded
		if (currentRequests < limit) {
			requestCounts.put(clientId, now);
			return true; // Request is allowed
		}

		return false; // Limit exceeded
	}

	public static void main(String[] args) {
		// Limit 5 requests per 10 seconds
		FixedWindowRateLimiter limiter = new FixedWindowRateLimiter(5, Duration.ofSeconds(10));

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