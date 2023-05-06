package com.sapient.model;

import java.sql.Timestamp;

import com.sapient.vehicleType.VehicleType;

/**
 * The Class Token.
 *
 * @author Hareram
 */
public class Token {

	/** The vehicle number. */
	private String vehicleNumber;

	/** The slots. */
	private Slot[] slots;

	/** The vehicle in time. */
	private Timestamp vehicleInTime;

	/** The vehicle out time. */
	private Timestamp vehicleOutTime;

	/** The vehicle type. */
	private VehicleType vehicleType;

	/**
	 * This method allocate the slots for the vehicle according to vehicle type.
	 *
	 * @param vehicle
	 *            the vehicle
	 * @param slot
	 *            the slot
	 */
	private void allocateSlot(Vehicle vehicle, Slot[] slot) {
		for (int i = 0; i < slot.length; i++) {
			slot[i].setSlotOccupied(true);
			slot[i].setVehicleNumber(vehicle.getVehicleNumber());
			slot[i].setVehicleInTime(new Timestamp(System.currentTimeMillis()));
		}
	}

	/**
	 * This method generates the token for the vehicle and allocates the slot
	 * where the vehicle should be parked.
	 *
	 * @param vehicle
	 *            the vehicle
	 * @param slot
	 *            the slot
	 * @return token
	 */
	public Token generateTokenAndPark(Vehicle vehicle, Slot[] slot) {
		Token token = new Token();
		token.setVehicleNumber(vehicle.getVehicleNumber());
		token.setSlots(slot);
		token.setVehicleInTime(new Timestamp(System.currentTimeMillis()));
		token.setVehicleOutTime(null);

		allocateSlot(vehicle, slot);

		return token;
	}

	/**
	 * Gets the vehicle number.
	 *
	 * @return vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * Sets the vehicle number.
	 *
	 * @param vehicleNumber
	 *            the new vehicle number
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	/**
	 * Gets the slots.
	 *
	 * @return slots
	 */
	public Slot[] getSlots() {
		return slots;
	}

	/**
	 * Sets the slots.
	 *
	 * @param slots
	 *            the new slots
	 */
	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}

	/**
	 * Gets the vehicle in time.
	 *
	 * @return vehicleInTime
	 */
	public Timestamp getVehicleInTime() {
		return vehicleInTime;
	}

	/**
	 * Sets the vehicle in time.
	 *
	 * @param vehicleInTime
	 *            the new vehicle in time
	 */
	public void setVehicleInTime(Timestamp vehicleInTime) {
		this.vehicleInTime = vehicleInTime;
	}

	/**
	 * Gets the vehicle out time.
	 *
	 * @return vehicleOutTime
	 */
	public Timestamp getVehicleOutTime() {
		return vehicleOutTime;
	}

	/**
	 * Sets the vehicle out time.
	 *
	 * @param vehicleOutTime
	 *            the new vehicle out time
	 */
	public void setVehicleOutTime(Timestamp vehicleOutTime) {
		this.vehicleOutTime = vehicleOutTime;
	}

	/**
	 * Gets the vehicle type.
	 *
	 * @return the vehicle type
	 */
	public VehicleType getVehicleType() {
		return vehicleType;
	}

	/**
	 * Sets the vehicle type.
	 *
	 * @param vehicleType
	 *            the new vehicle type
	 */
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}