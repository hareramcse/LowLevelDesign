package com.hs.amountwithdrawal;

public class Dollar500Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void withdraw(int amount) {
		if (amount >= 500) {
			int num = amount / 500;
			int remainder = amount % 500;
			System.out.println("Dispensing " + num + " 500$ note");
			if (remainder != 0)
				this.chain.withdraw(remainder);
		} else {
			this.chain.withdraw(amount);
		}
	}
}
