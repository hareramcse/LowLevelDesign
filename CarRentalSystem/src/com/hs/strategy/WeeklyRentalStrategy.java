package com.hs.strategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.hs.Vehicle;

/** Charges per complete week with a 10% discount vs daily rate × 7. */
public class WeeklyRentalStrategy implements PricingStrategy {
	@Override
	public double calculateCost(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
		long days = Math.max(1, ChronoUnit.DAYS.between(startDate, endDate));
		double weeks = Math.ceil(days / 7.0);
		return weeks * vehicle.getRentalCostPerDay() * 7 * 0.9;
	}
}
