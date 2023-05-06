package com.sapient.exception;

/**
 * The Class VehicleNumberNotValidException.
 * 
 * @author Hareram
 */
public class VehicleNumberNotValidException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new vehicle number not valid exception.
	 *
	 * @param message
	 *            the message
	 */
	public VehicleNumberNotValidException(String message) {
		super(message);
	}
}
