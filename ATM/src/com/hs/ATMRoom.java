package com.hs;

import com.hs.states.IdleState;

public class ATMRoom {
	private ATM atm;
	private User user;

	public void initialize() {
		atm = ATM.getATMObject();
		atm.setCurrentState(new IdleState());
		atm.setAtmBalance(3500, 1, 2, 5);
		this.user = createUser();
	}

	private User createUser() {
		User user = new User();
		user.setCard(createCard());
		return user;
	}

	private Card createCard() {
		Card card = new Card();
		card.setBankAccount(createBankAccount());
		return card;
	}

	private BankAccount createBankAccount() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(3000);
		return bankAccount;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}
}