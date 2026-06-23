package com.hs;

public class Payment {
	private final String paymentId;

	public Payment(String paymentId, PaymentMethod paymentMethod, double amount) {
		this.paymentId = paymentId;
	}

	public String getPaymentId() {
		return paymentId;
	}
}
