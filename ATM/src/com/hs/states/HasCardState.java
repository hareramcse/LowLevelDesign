package com.hs.states;

import com.hs.ATM;
import com.hs.Card;

public class HasCardState extends ATMState {
	private final ATM atm = ATM.getATMObject();

	public HasCardState() {
		System.out.println("enter your card pin number");
	}

	@Override
	public void authenticatePin(Card card, int pin) {
		if (card.isCorrectPINEntered(pin)) {
			atm.setCurrentState(new SelectOperationState());
		} else {
			System.out.println("Invalid PIN Number");
			returnToIdle(atm);
		}
	}

	@Override
	public void exit(ATM atm) {
		returnToIdle(atm);
	}
}
