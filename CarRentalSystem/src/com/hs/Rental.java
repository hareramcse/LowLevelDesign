package com.hs;

import java.time.LocalDate;

public class Rental {
	private final String rentalId;
	private final Customer customer;
	private final Vehicle vehicle;
	private final LocalDate startDate;
	private final LocalDate endDate;
	private final double amountPaid;
	private RentalStatus status;

	public Rental(String rentalId, Customer customer, Vehicle vehicle, LocalDate startDate, LocalDate endDate,
			double amountPaid) {
		this.rentalId = rentalId;
		this.customer = customer;
		this.vehicle = vehicle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amountPaid = amountPaid;
		this.status = RentalStatus.ACTIVE;
	}

	public String rentalId() {
		return rentalId;
	}

	public Customer customer() {
		return customer;
	}

	public Vehicle vehicle() {
		return vehicle;
	}

	public LocalDate startDate() {
		return startDate;
	}

	public LocalDate endDate() {
		return endDate;
	}

	public double amountPaid() {
		return amountPaid;
	}

	public RentalStatus status() {
		return status;
	}

	void complete() {
		status = RentalStatus.COMPLETED;
	}

	boolean overlaps(LocalDate start, LocalDate end) {
		return startDate.isBefore(end) && start.isBefore(endDate);
	}

	boolean isActive() {
		return status == RentalStatus.ACTIVE;
	}

	@Override
	public String toString() {
		return "Rental " + rentalId + " | vehicle=" + vehicle.getVehicleID() + " | " + startDate + " to " + endDate
				+ " | $" + amountPaid + " | " + status;
	}
}
