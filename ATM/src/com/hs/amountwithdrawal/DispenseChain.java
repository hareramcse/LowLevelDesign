package com.hs.amountwithdrawal;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void withdraw(int amount);
}