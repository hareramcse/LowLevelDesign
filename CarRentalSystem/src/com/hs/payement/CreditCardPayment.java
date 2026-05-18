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

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}