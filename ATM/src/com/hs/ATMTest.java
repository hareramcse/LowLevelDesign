package com.hs;

public class ATMTest {
	public static void main(String[] args) {
		ATMRoom atmRoom = new ATMRoom();
		atmRoom.initialize();

		ATM atm = atmRoom.getAtm();
		User user = atmRoom.getUser();
		atm.printCurrentATMStatus();
		atm.getCurrentState().insertCard(user.getCard());
		atm.getCurrentState().authenticatePin(user.getCard(), 112211);
		atm.getCurrentState().selectOperation(user.getCard(), TransactionType.CASH_WITHDRAWAL);
		atm.getCurrentState().cashWithdrawal(user.getCard(), 2700);
		atm.printCurrentATMStatus();
	}
}
