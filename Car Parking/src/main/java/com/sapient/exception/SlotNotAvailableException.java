package com.sapient.exception;

/**
 * The Class SlotNotAvailableException, it is thrown when slot is not available
 * to park the vehicle.
 *
 * @author Hareram
 */
public class SlotNotAvailableException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new slot not available exception.
	 *
	 * @param message
	 *            the message
	 */
	public SlotNotAvailableException(String message) {
		super(message);
	}
}
