package com.hs;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy {
	@Override
	public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, VehicleType vehicleType) {
		long hours = Math.max(1, Duration.between(entryTime, exitTime).toHours());
		double ratePerHour = switch (vehicleType) {
			case MOTORCYCLE -> 2.0;
			case CAR -> 5.0;
			case TRUCK -> 10.0;
		};
		return hours * ratePerHour;
	}
}
