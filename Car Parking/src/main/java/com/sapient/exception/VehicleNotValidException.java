package com.sapient.exception;

/**
 * The Class VehicleNotValidException.
 * 
 * @author Hareram
 */
public class VehicleNotValidException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new vehicle not valid exception.
	 *
	 * @param message
	 *            the message
	 */
	public VehicleNotValidException(String message) {
		super(message);
	}
}
