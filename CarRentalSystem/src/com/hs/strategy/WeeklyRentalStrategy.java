package com.hs.strategy;

public class WeeklyRentalStrategy implements PricingStrategy {
	private double weeklyRate;

	public WeeklyRentalStrategy(double weeklyRate) {
		this.weeklyRate = weeklyRate;
	}

	@Override
	public double calculateRentalCost(int days) {
		return weeklyRate * Math.ceil(days / 7.0); // Charge for complete weeks
	}
}