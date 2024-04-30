package com.hs.states;

import com.hs.ATM;
import com.hs.Card;

public class IdleState extends ATMState {
	private ATM atm;
	
	public IdleState() {
		atm = ATM.getATMObject();
	}

	@Override
	public void insertCard(Card card) {
		System.out.println("Card is inserted");
		atm.setCurrentState(new HasCardState());
	}
}
