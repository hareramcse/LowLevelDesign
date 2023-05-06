package com.sapient.model;

import com.sapient.vehicleType.VehicleType;

/**
 * The Interface Vehicle.
 *
 * @author Hareram
 */
public interface Vehicle {

	/**
	 * Gets the vehicle type.
	 *
	 * @return the vehicle type
	 */
	public VehicleType getVehicleType();

	/**
	 * Gets the vehicle number.
	 *
	 * @return the vehicle number
	 */
	public String getVehicleNumber();
}