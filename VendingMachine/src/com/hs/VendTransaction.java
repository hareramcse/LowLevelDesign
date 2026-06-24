package com.hs;

public class VendTransaction {
	private final String transactionId;
	private final Product product;
	private double amountPaid;
	private VendStatus status;

	public VendTransaction(String transactionId, Product product) {
		this.transactionId = transactionId;
		this.product = product;
		this.status = VendStatus.SELECTED;
	}

	public String transactionId() {
		return transactionId;
	}

	public Product product() {
		return product;
	}

	public double amountPaid() {
		return amountPaid;
	}

	public VendStatus status() {
		return status;
	}

	void addPayment(double amount) {
		amountPaid += amount;
	}

	void markPaid() {
		status = VendStatus.PAID;
	}

	void complete() {
		status = VendStatus.COMPLETED;
	}

	void cancel() {
		status = VendStatus.CANCELLED;
	}

	double changeDue() {
		return Math.max(0, amountPaid - product.price());
	}

	@Override
	public String toString() {
		return "Txn " + transactionId + " | " + product.name() + " | paid=$" + amountPaid + " | " + status;
	}
}
