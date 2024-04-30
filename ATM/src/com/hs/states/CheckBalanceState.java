package com.hs.states;

import com.hs.ATM;
import com.hs.Card;

public class CheckBalanceState extends ATMState {
	private ATM atm;

	public CheckBalanceState() {
		atm = ATM.getATMObject();
	}

	@Override
	public void displayBalance(Card card) {
		System.out.println("Your Balance is: " + card.getBankBalance());
		exit(atm);
	}

	@Override
	public void exit(ATM atm) {
		returnCard();
		atm.setCurrentState(new IdleState());
		System.out.println("Exit happens");
	}

	@Override
	public void returnCard() {
		System.out.println("Please collect your card");
	}
}
