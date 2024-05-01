package com.hs.payement;

public class CreditCardPayment implements PaymentMethod {
	private String cardNumber;
	private String expirationDate;
	private String cvv;

	public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}

	@Override
	public void processPayment(double amount) {
		// Process credit card payment logic
		System.out.println("Processing credit card payment of $" + amount);
		// Additional logic can be added here, such as connecting to a payment gateway
	}
}