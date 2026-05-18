package com.hs;

import java.time.Instant;

public class LeakingBucketRateLimiter {
	private final int capacity;
	private double water;
	private Instant lastLeakTime;

	public LeakingBucketRateLimiter(int capacity, double leakRatePerSecond) {
		this.capacity = capacity;
		this.water = 0;
		this.lastLeakTime = Instant.now();
		setLeakRate(leakRatePerSecond);
	}

	public synchronized boolean tryConsume(double waterToConsume) {
		leak();
		if (water + waterToConsume <= capacity) {
			water += waterToConsume;
			return true; // Water level within capacity, consume successful
		}
		return false; // Insufficient capacity
	}

	private void leak() {
		Instant currentTime = Instant.now();
		double elapsedTime = currentTime.minusMillis(lastLeakTime.toEpochMilli()).toEpochMilli() / 1000.0;
		double leakedWater = elapsedTime * getLeakRate();
		water = Math.max(0, water - leakedWater);
		lastLeakTime = currentTime;
	}

	private double getLeakRate() {
		return capacity / 10.0; // Example: Leak rate is 1/10th of the bucket capacity per second
	}

	private void setLeakRate(double leakRatePerSecond) {
		if (leakRatePerSecond > 0) {
			water = Math.min(capacity, water + leakRatePerSecond);
		}
	}

	public static void main(String[] args) {
		// 10 capacity, leak rate of 0.5 units/second
		LeakingBucketRateLimiter limiter = new LeakingBucketRateLimiter(10, 0.5);

		// Try adding water
		for (int i = 0; i < 15; i++) {
			boolean result = limiter.tryConsume(1.0);
			if (result) {
				System.out.println("Water added successfully");
			} else {
				System.out.println("Water addition failed: Bucket overflow");
			}
		}
	}
}
