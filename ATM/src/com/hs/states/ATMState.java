package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.TransactionType;

public abstract class ATMState {

	public void insertCard(Card card) {
		System.out.println("OOPS!! Something went wrong");
	}

	public void authenticatePin(Card card, int pin) {
		System.out.println("OOPS!! Something went wrong");
	}

	public void selectOperation(Card card, TransactionType txnType) {
		System.out.println("OOPS!! Something went wrong");
	}

	public void cashWithdrawal(Card card, int withdrawAmount) {
		System.out.println("OOPS!! Something went wrong");
	}

	public void displayBalance(Card card) {
		System.out.println("OOPS!! Something went wrong");
	}

	public void returnCard() {
		System.out.println("OOPS!! Something went wrong");
	}

	public void exit(ATM atm) {
		System.out.println("OOPS!! Something went wrong");
	}
}
