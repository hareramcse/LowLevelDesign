package com.hs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.hs.payment.PaymentMethod;
import com.hs.strategy.PricingStrategy;

public class RentalSystem {
	private final Map<Integer, Vehicle> vehicles = new HashMap<>();
	private final Map<Integer, Customer> customers = new HashMap<>();
	private final Map<String, Rental> rentals = new HashMap<>();

	public void addVehicle(Vehicle vehicle) {
		vehicles.put(vehicle.getVehicleID(), vehicle);
	}

	public void addCar(int vehicleID, String model, double rentalCostPerDay) {
		addVehicle(VehicleType.CAR.createVehicle(vehicleID, model, rentalCostPerDay));
	}

	public void addMotorcycle(int vehicleID, String model, double rentalCostPerDay) {
		addVehicle(VehicleType.MOTORCYCLE.createVehicle(vehicleID, model, rentalCostPerDay));
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getCustomerID(), customer);
	}

	public List<Vehicle> searchAvailable(LocalDate startDate, LocalDate endDate, VehicleType type) {
		return vehicles.values().stream()
				.filter(v -> type == null || v.getType() == type)
				.filter(v -> isAvailable(v, startDate, endDate))
				.toList();
	}

	public synchronized Optional<Rental> reserve(int customerId, int vehicleId, LocalDate startDate, LocalDate endDate,
			PricingStrategy pricingStrategy, PaymentMethod paymentMethod) {
		Customer customer = customers.get(customerId);
		Vehicle vehicle = vehicles.get(vehicleId);
		if (customer == null || vehicle == null) {
			System.out.println("Invalid customer or vehicle ID.");
			return Optional.empty();
		}
		if (!startDate.isBefore(endDate)) {
			System.out.println("End date must be after start date.");
			return Optional.empty();
		}
		if (!isAvailable(vehicle, startDate, endDate)) {
			System.out.println("Vehicle " + vehicleId + " not available for " + startDate + " to " + endDate);
			return Optional.empty();
		}
		double cost = pricingStrategy.calculateCost(vehicle, startDate, endDate);
		paymentMethod.processPayment(cost);
		Rental rental = new Rental(UUID.randomUUID().toString(), customer, vehicle, startDate, endDate, cost);
		rentals.put(rental.rentalId(), rental);
		System.out.println("Reserved: " + rental);
		return Optional.of(rental);
	}

	public synchronized Optional<ReturnReceipt> returnRental(String rentalId, LocalDate actualReturnDate) {
		Rental rental = rentals.get(rentalId);
		if (rental == null || !rental.isActive()) {
			System.out.println("Invalid or inactive rental: " + rentalId);
			return Optional.empty();
		}
		double lateFee = calculateLateFee(rental, actualReturnDate);
		if (lateFee > 0) {
			System.out.println("Late return fee: $" + lateFee);
		}
		rental.complete();
		return Optional.of(new ReturnReceipt(rentalId, actualReturnDate, lateFee, rental.amountPaid() + lateFee));
	}

	private double calculateLateFee(Rental rental, LocalDate actualReturnDate) {
		if (!actualReturnDate.isAfter(rental.endDate())) {
			return 0;
		}
		long extraDays = ChronoUnit.DAYS.between(rental.endDate(), actualReturnDate);
		return extraDays * rental.vehicle().getRentalCostPerDay() * 1.5;
	}

	private boolean isAvailable(Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
		return rentals.values().stream()
				.filter(Rental::isActive)
				.filter(r -> r.vehicle().getVehicleID() == vehicle.getVehicleID())
				.noneMatch(r -> r.overlaps(startDate, endDate));
	}

	public List<Rental> getActiveRentals() {
		return rentals.values().stream().filter(Rental::isActive).toList();
	}

	public void displayFleet() {
		System.out.println("Fleet:");
		vehicles.values().forEach(v -> System.out.println("  " + v));
	}
}
