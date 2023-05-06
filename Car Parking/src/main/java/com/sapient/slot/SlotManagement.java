package com.sapient.slot;

import java.util.Queue;

import com.sapient.model.Slot;
import com.sapient.model.Token;
import com.sapient.model.Vehicle;

/**
 * The Interface SlotManagement.
 * 
 * @author Hareram
 */
public interface SlotManagement {

	/**
	 * This method initialize the slot with slot id.
	 */
	public void initSlot();

	/**
	 * This method returns the number of available slot at any time.
	 *
	 * @return the count value of slot
	 */
	public int findNumberOfAvailableSlot();

	/**
	 * Check available slot.
	 *
	 * @param vehicle
	 *            the vehicle
	 * @return the slot[]
	 */
	public Slot[] checkAvailableSlot(Vehicle vehicle);

	/**
	 * Release slot when vehicle exit from parking.
	 *
	 * @param token
	 *            the token
	 */
	public void releaseSlot(Token token);

	/**
	 * Gets the empty slot.
	 *
	 * @return the empty slot
	 */
	public Queue<Slot> getEmptySlot();
}