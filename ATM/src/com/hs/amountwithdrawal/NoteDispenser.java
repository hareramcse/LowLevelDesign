package com.hs.amountwithdrawal;

/** Chain of Responsibility: dispense largest notes first, pass remainder down the chain. */
public class NoteDispenser implements DispenseChain {
	private final int denomination;
	private DispenseChain next;

	public NoteDispenser(int denomination) {
		this.denomination = denomination;
	}

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.next = nextChain;
	}

	@Override
	public void withdraw(int amount) {
		if (amount >= denomination) {
			int count = amount / denomination;
			int remainder = amount % denomination;
			System.out.println("Dispensing " + count + " " + denomination + "$ note");
			if (remainder != 0 && next != null) {
				next.withdraw(remainder);
			}
		} else if (next != null) {
			next.withdraw(amount);
		}
	}
}
