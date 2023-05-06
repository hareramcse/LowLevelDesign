package com.sapient.main;

import org.apache.log4j.Logger;

import com.sapient.vehicle.VehicleManagement;
import com.sapient.vehicle.impl.VehicleManagementImpl;

/**
 * The Class VehicleParking.
 *
 * @author Hareram
 */
public class VehicleParking {

	/** The logger. */
	static Logger logger = Logger.getLogger(VehicleParking.class);

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		VehicleManagement vehicleManagement = new VehicleManagementImpl();
		try {
			vehicleManagement.vehicleEntryAndExit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}