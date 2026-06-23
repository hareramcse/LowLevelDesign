package com.hs.states;

import com.hs.ATM;
import com.hs.Card;

public class CheckBalanceState extends ATMState {
	private final ATM atm = ATM.getATMObject();

	@Override
	public void displayBalance(Card card) {
		System.out.println("Your Balance is: " + card.getBankBalance());
		returnToIdle(atm);
	}

	@Override
	public void exit(ATM atm) {
		returnToIdle(atm);
	}
}
