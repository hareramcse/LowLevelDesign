package com.sapient.vehicle;

import java.util.Map;

import com.sapient.model.Token;
import com.sapient.model.Vehicle;
import com.sapient.payement.PaymentManagement;
import com.sapient.slot.SlotManagement;

/**
 * The Interface VehicleManagement.
 * 
 * @author Hareram
 */
public interface VehicleManagement {

	/**
	 * Vehicle entry and exit.
	 */
	public void vehicleEntryAndExit();

	/**
	 * Generate report.
	 *
	 * @param slotManagement
	 *            the slot management
	 * @param paymentManagement
	 *            the payment management
	 */
	public void generateReport(SlotManagement slotManagement, PaymentManagement paymentManagement);

	/**
	 * Sets the vehicles.
	 *
	 * @param vehicleMap
	 *            the vehicle map
	 */
	public void setVehicles(Map<String, Vehicle> vehicleMap);

	/**
	 * Sets the vehicle map.
	 *
	 * @param tokenMap
	 *            the token map
	 */
	public void setVehicleMap(Map<String, Token> tokenMap);;
}