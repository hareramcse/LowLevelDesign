package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.amountwithdrawal.DispenseChain;
import com.hs.amountwithdrawal.NoteDispenser;

public class CashWithdrawalState extends ATMState {
	private final ATM atm = ATM.getATMObject();

	public CashWithdrawalState() {
		System.out.println("Please enter the Withdrawal Amount");
	}

	@Override
	public void cashWithdrawal(Card card, int withdrawalAmountRequest) {
		System.out.println("Request to withdraw amount " + withdrawalAmountRequest);
		if (atm.getAtmBalance() < withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the ATM Machine");
			returnToIdle(atm);
		} else if (card.getBankBalance() < withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the your Bank Account");
			returnToIdle(atm);
		} else {
			card.deductBankBalance(withdrawalAmountRequest);
			atm.deductATMBalance(withdrawalAmountRequest);

			DispenseChain d2000 = new NoteDispenser(2000);
			DispenseChain d500 = new NoteDispenser(500);
			DispenseChain d100 = new NoteDispenser(100);
			d2000.setNextChain(d500);
			d500.setNextChain(d100);
			d2000.withdraw(withdrawalAmountRequest);

			System.out.println("Withdrawal is successfull");
			returnToIdle(atm);
		}
	}

	@Override
	public void exit(ATM atm) {
		returnToIdle(atm);
	}
}
