package com.hs.states;

import com.hs.ATM;
import com.hs.Card;
import com.hs.amountwithdrawal.DispenseChain;
import com.hs.amountwithdrawal.Dollar100Dispenser;
import com.hs.amountwithdrawal.Dollar500Dispenser;
import com.hs.amountwithdrawal.Dollar2000Dispenser;

public class CashWithdrawalState extends ATMState {
	private ATM atm;

	public CashWithdrawalState() {
		atm = ATM.getATMObject();
		System.out.println("Please enter the Withdrawal Amount");
	}

	public void cashWithdrawal(Card card, int withdrawalAmountRequest) {
		System.out.println("Request to withdraw amount " + withdrawalAmountRequest);
		if (atm.getAtmBalance() < withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the ATM Machine");
			exit(atm);
		} else if (card.getBankBalance() < withdrawalAmountRequest) {
			System.out.println("Insufficient fund in the your Bank Account");
			exit(atm);
		} else {
			card.deductBankBalance(withdrawalAmountRequest);
			atm.deductATMBalance(withdrawalAmountRequest);

			DispenseChain chain1 = new Dollar2000Dispenser();
			DispenseChain chain2 = new Dollar500Dispenser();
			DispenseChain chain3 = new Dollar100Dispenser();

			// set the chain of responsibility
			chain1.setNextChain(chain2);
			chain2.setNextChain(chain3);

			chain1.withdraw(withdrawalAmountRequest);
			exit(atm);
		}
	}

	@Override
	public void exit(ATM atmObject) {
		returnCard();
		atmObject.setCurrentState(new IdleState());
		System.out.println("Exit happens");
	}

	@Override
	public void returnCard() {
		System.out.println("Withdrawal is successfull");
		System.out.println("Please collect your card");
	}
}
