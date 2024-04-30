package com.hs.amountwithdrawal;

public class Dollar100Dispenser implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void withdraw(int amount) {
		if (amount >= 100) {
			int num = amount / 100;
			int remainder = amount % 100;
			System.out.println("Dispensing " + num + " 100$ note");
			if (remainder != 0)
				this.chain.withdraw(remainder);
		} else {
			this.chain.withdraw(amount);
		}
	}

}