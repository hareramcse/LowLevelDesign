package com.hs;

import com.hs.states.IdleState;

public class ATMRoom {
	private ATM atm;
	private User user;

	public void initialize() {
		atm = ATM.getATMObject();
		atm.setCurrentState(new IdleState());
		atm.setAtmBalance(3500, 1, 2, 5);
		user = new User(new Card(new BankAccount(3000)));
	}

	public ATM getAtm() {
		return atm;
	}

	public User getUser() {
		return user;
	}
}
