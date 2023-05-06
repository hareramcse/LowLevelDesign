package com.sapient.model;

import java.sql.Timestamp;

/**
 * The Class Slot.
 *
 * @author Hareram
 */
public class Slot {

	/** The x and y coordinates of the slot. */
	private int xCoordiate, yCoordinate;

	/** The slot occupied. */
	private boolean slotOccupied;

	/** The vehicle in time. */
	private Timestamp vehicleInTime;

	/** The vehicle out time. */
	private Timestamp vehicleOutTime;

	/** The vehicle number. */
	private String vehicleNumber;

	/**
	 * Instantiates a new slot.
	 *
	 * @param xCoordiate
	 *            the x coordiate
	 * @param yCoordiate
	 *            the y coordiate
	 */
	public Slot(int xCoordiate, int yCoordiate) {
		this.xCoordiate = xCoordiate;
		this.yCoordinate = yCoordiate;
		this.slotOccupied = false;
		this.vehicleInTime = null;
		this.vehicleOutTime = null;
		this.vehicleNumber = "";
	}

	/**
	 * Checks if is slot occupied.
	 *
	 * @return slotOccupied
	 */
	public boolean isSlotOccupied() {
		return slotOccupied;
	}

	/**
	 * Sets the slot occupied.
	 *
	 * @param slotOccupied
	 *            the new slot occupied
	 */
	public void setSlotOccupied(boolean slotOccupied) {
		this.slotOccupied = slotOccupied;
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
	 * Sets the vehicle number.
	 *
	 * @param vehicleNumber
	 *            the new vehicle number
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	/**
	 * Sets the x coordiate.
	 *
	 * @param xCoordiate the new x coordiate
	 */
	public void setxCoordiate(int xCoordiate) {
		this.xCoordiate = xCoordiate;
	}
	
	/**
	 * Gets the x coordiate.
	 *
	 * @return the x coordiate
	 */
	public int getxCoordiate() {
		return xCoordiate;
	}
	
	/**
	 * Sets the y coordinate.
	 *
	 * @param yCoordinate the new y coordinate
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	/**
	 * Gets the y coordinate.
	 *
	 * @return the y coordinate
	 */
	public int getyCoordinate() {
		return yCoordinate;
	}
}