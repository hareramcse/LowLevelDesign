package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.TransactionType;

public class SelectOperationState extends ATMState {
	private ATM atm;

	public SelectOperationState() {
		atm = ATM.getATMObject();
		showOperations();
	}

	@Override
	public void selectOperation(Card card, TransactionType txnType) {

		switch (txnType) {

		case CASH_WITHDRAWAL:
			System.out.println("Selected operation is withdrawal");
			atm.setCurrentState(new CashWithdrawalState());
			break;
		case BALANCE_CHECK:
			atm.setCurrentState(new CheckBalanceState());
			break;
		default: {
			System.out.println("Invalid Option");
			exit(atm);
		}

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

	private void showOperations() {
		System.out.println("Please select the Operation");
		TransactionType.showAllTransactionTypes();
	}
}