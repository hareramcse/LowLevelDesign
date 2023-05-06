package com.sapient.model;

import com.sapient.vehicleType.VehicleType;

/**
 * The Class Truck.
 * 
 * @author Hareram
 */
public class Truck implements Vehicle {

	/** The vehicle type. */
	private VehicleType vehicleType;

	/** The vehicle number. */
	private String vehicleNumber;

	/**
	 * Instantiates a new truck.
	 *
	 * @param vehicleType
	 *            the vehicle type
	 * @param vehicleNumber
	 *            the vehicle number
	 */
	public Truck(VehicleType vehicleType, String vehicleNumber) {
		this.vehicleType = vehicleType;
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * Gets the vehicle type.
	 *
	 * @return vehicleType
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * Gets the vehicle number.
	 *
	 * @return vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}
}