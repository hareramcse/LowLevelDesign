package com.hs.amountwithdrawal;

public class Dollar2000Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void withdraw(int amount) {
		if (amount >= 2000) {
			int num = amount / 2000;
			int remainder = amount % 2000;
			System.out.println("Dispensing " + num + " 2000$ note");
			if (remainder != 0)
				this.chain.withdraw(remainder);
		} else {
			this.chain.withdraw(amount);
		}
	}
}