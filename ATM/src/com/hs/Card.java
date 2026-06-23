package com.hs;

public class Card {
	private static final int PIN = 112211;
	private final BankAccount bankAccount;

	public Card(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public boolean isCorrectPINEntered(int pin) {
		return pin == PIN;
	}

	public int getBankBalance() {
		return bankAccount.getBalance();
	}

	public void deductBankBalance(int amount) {
		bankAccount.withdraw(amount);
	}
}
