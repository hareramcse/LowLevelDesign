package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.TransactionType;

public class SelectOperationState extends ATMState {
	private final ATM atm = ATM.getATMObject();

	public SelectOperationState() {
		System.out.println("Please select the Operation");
		TransactionType.showAllTransactionTypes();
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
		default:
			System.out.println("Invalid Option");
			returnToIdle(atm);
		}
	}

	@Override
	public void exit(ATM atm) {
		returnToIdle(atm);
	}
}
