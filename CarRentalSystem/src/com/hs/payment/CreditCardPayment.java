package com.hs.payment;

public class CreditCardPayment implements PaymentMethod {
	private final String cardNumber;
	private final String expirationDate;
	private final String cvv;

	public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Processing credit card payment of $" + amount);
	}
}
