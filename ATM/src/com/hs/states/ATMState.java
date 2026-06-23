package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.TransactionType;

/** State pattern: each ATM screen is a state with allowed actions. */
public abstract class ATMState {
	protected void returnToIdle(ATM atm) {
		System.out.println("Please collect your card");
		atm.setCurrentState(new IdleState());
		System.out.println("Exit happens");
	}

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
