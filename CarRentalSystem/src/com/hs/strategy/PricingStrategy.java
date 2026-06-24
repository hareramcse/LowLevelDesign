package com.hs.strategy;

import java.time.LocalDate;

import com.hs.Vehicle;

public interface PricingStrategy {
	double calculateCost(Vehicle vehicle, LocalDate startDate, LocalDate endDate);
}
