package com.hs;

public class Card {
	private int cardNumber;
	private int PIN_NUMBER = 112211;
	private BankAccount bankAccount;

	public boolean isCorrectPINEntered(int pin) {
		if (pin == PIN_NUMBER) {
			return true;
		}
		return false;
	}

	public int getBankBalance() {
		return bankAccount.getBalance();
	}

	public void deductBankBalance(int amount) {
		bankAccount.withdrawalBalance(amount);
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPIN_NUMBER() {
		return PIN_NUMBER;
	}

	public void setPIN_NUMBER(int pIN_NUMBER) {
		PIN_NUMBER = pIN_NUMBER;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

}
