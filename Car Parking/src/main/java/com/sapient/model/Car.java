package com.sapient.model;

import com.sapient.vehicleType.VehicleType;

/**
 * The Class Car.
 * 
 * @author Hareram
 */
public class Car implements Vehicle {

	/** The vehicle type. */
	private VehicleType vehicleType;

	/** The vehicle number. */
	private String vehicleNumber;

	/**
	 * Instantiates a new car.
	 *
	 * @param vehicleType
	 *            the vehicle type
	 * @param vehicleNumber
	 *            the vehicle number
	 */
	public Car(VehicleType vehicleType, String vehicleNumber) {
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