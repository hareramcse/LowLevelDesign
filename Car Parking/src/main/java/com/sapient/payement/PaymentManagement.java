package com.sapient.payement;

import com.sapient.exception.PaymentExcepion;
import com.sapient.model.Token;

/**
 * The Interface PaymentManagement.
 * 
 * @author Hareram
 */
public interface PaymentManagement {

	
	/**
	 * Do payment.
	 *
	 * @param token the token
	 * @param hours the hours
	 * @throws PaymentExcepion the payment excepion
	 */
	public void doPayment(Token token, String hours) throws PaymentExcepion;

	/**
	 * Gets the total fees paid.
	 *
	 * @return the total fees paid
	 */
	public double getTotalFeesPaid();
}