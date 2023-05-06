package com.sapient.exception;

/**
 * The Class PaymentExcepion.
 * 
 * @author Hareram
 */
public class PaymentExcepion extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new payment excepion.
	 *
	 * @param message
	 *            the message
	 */
	public PaymentExcepion(String message) {
		super(message);
	}
}
