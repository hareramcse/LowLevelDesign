package com.hs;

import com.hs.states.ATMState;

public class ATM {
	private int atmBalance;
	private int noOfTwoThousandNotes;
	private int noOfFiveHundredNotes;
	private int noOfOneHundredNotes;
	private ATMState currentState;
	private static ATM atmObject = new ATM(); // Singleton: eager initialization

	private ATM() {
	}

	public void setCurrentState(ATMState currentState) {
		this.currentState = currentState;
	}

	public ATMState getCurrentState() {
		return currentState;
	}

	public static ATM getATMObject() {
		return atmObject;
	}

	public int getAtmBalance() {
		return atmBalance;
	}

	public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes,
			int noOfOneHundredNotes) {
		this.atmBalance = atmBalance;
		this.noOfTwoThousandNotes = noOfTwoThousandNotes;
		this.noOfFiveHundredNotes = noOfFiveHundredNotes;
		this.noOfOneHundredNotes = noOfOneHundredNotes;
	}

	public int getNoOfTwoThousandNotes() {
		return noOfTwoThousandNotes;
	}

	public int getNoOfFiveHundredNotes() {
		return noOfFiveHundredNotes;
	}

	public int getNoOfOneHundredNotes() {
		return noOfOneHundredNotes;
	}

	public void deductATMBalance(int amount) {
		atmBalance = atmBalance - amount;
	}

	public void deductTwoThousandNotes(int number) {
		noOfTwoThousandNotes = noOfTwoThousandNotes - number;
	}

	public void deductFiveHundredNotes(int number) {
		noOfFiveHundredNotes = noOfFiveHundredNotes - number;
	}

	public void deductOneHundredNotes(int number) {
		noOfOneHundredNotes = noOfOneHundredNotes - number;
	}

	public void printCurrentATMStatus() {
		System.out.println("Balance: " + atmBalance);
		System.out.println("2kNotes: " + noOfTwoThousandNotes);
		System.out.println("500Notes: " + noOfFiveHundredNotes);
		System.out.println("100Notes: " + noOfOneHundredNotes);
	}
}