package com.hs;

public class Customer {
	private final int customerID;
	private final String name;
	private final String phoneNumber;

	public Customer(int customerID, String name, String phoneNumber) {
		this.customerID = customerID;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerID + ", Name: " + name + ", Phone: " + phoneNumber;
	}
}
