package com.hs.strategy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.hs.Vehicle;

public class DailyRentalStrategy implements PricingStrategy {
	@Override
	public double calculateCost(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
		long days = Math.max(1, ChronoUnit.DAYS.between(startDate, endDate));
		return days * vehicle.getRentalCostPerDay();
	}
}
