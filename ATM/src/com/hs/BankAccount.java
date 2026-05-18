package com.hs;

public class BankAccount {
	private int balance;

	public void withdrawalBalance(int amount) {
		balance = balance - amount;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
}
