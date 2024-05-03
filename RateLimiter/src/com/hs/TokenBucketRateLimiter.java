package com.hs;

import java.time.Instant;

public class TokenBucketRateLimiter {
	private final int capacity;
	private double tokens;
	private Instant lastRefillTime;

	public TokenBucketRateLimiter(int capacity, double refillRatePerSecond) {
		this.capacity = capacity;
		this.tokens = capacity;
		this.lastRefillTime = Instant.now();
		refill(refillRatePerSecond);
	}

	public synchronized boolean tryConsume(double tokensToConsume) {
		refill(1.0); // Refill the bucket before consuming tokens
		if (tokens >= tokensToConsume) {
			tokens -= tokensToConsume;
			return true; // Tokens available, consume successful
		}
		return false; // Insufficient tokens
	}

	private void refill(double refillRatePerSecond) {
		Instant currentTime = Instant.now();
		double elapsedTime = currentTime.minusMillis(lastRefillTime.toEpochMilli()).toEpochMilli() / 1000.0;
		double tokensToAdd = elapsedTime * refillRatePerSecond;
		tokens = Math.min(capacity, tokens + tokensToAdd);
		lastRefillTime = currentTime;
	}

	public static void main(String[] args) {
		// 10 tokens, refill rate of 0.5 tokens/second
		TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(10, 0.5); 
		
		// Try consuming tokens
		for (int i = 0; i < 15; i++) {
			boolean result = limiter.tryConsume(1.0);
			if (result) {
				System.out.println("Token consumed successfully");
			} else {
				System.out.println("Token consumption failed: Rate limit exceeded");
			}
		}
	}
}
