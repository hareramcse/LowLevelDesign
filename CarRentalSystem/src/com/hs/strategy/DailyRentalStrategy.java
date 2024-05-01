package com.hs.strategy;

public class DailyRentalStrategy implements PricingStrategy {
	private double dailyRate;

	public DailyRentalStrategy(double dailyRate) {
		this.dailyRate = dailyRate;
	}

	@Override
	public double calculateRentalCost(int days) {
		return dailyRate * days;
	}
}