package com.hs;

public class Payment {
	private String paymentId;
	private Booking booking;
	private PaymentMethod paymentMethod;
	private double amount;

	public Payment(String paymentId, Booking booking, PaymentMethod paymentMethod, double amount) {
		this.paymentId = paymentId;
		this.booking = booking;
		this.paymentMethod = paymentMethod;
		this.amount = amount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
