package com.hs.states;

import com.hs.ATM;
import com.hs.Card;

public class HasCardState extends ATMState {
	private ATM atm;
	
	public HasCardState() {
		atm = ATM.getATMObject();
		System.out.println("enter your card pin number");
	}

	@Override
	public void authenticatePin(Card card, int pin) {
		boolean isCorrectPinEntered = card.isCorrectPINEntered(pin);

		if (isCorrectPinEntered) {
			atm.setCurrentState(new SelectOperationState());
		} else {
			System.out.println("Invalid PIN Number");
			exit(atm);
		}
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
