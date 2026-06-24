package com.hs;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class ChangeMaker {
	public static Optional<Map<Coin, Integer>> makeChange(double amount, CashInventory cash) {
		if (amount <= 0) {
			return Optional.of(Map.of());
		}
		int cents = (int) Math.round(amount * 100);
		Map<Coin, Integer> result = new EnumMap<>(Coin.class);
		Map<Coin, Integer> available = new EnumMap<>(cash.snapshot());

		for (Coin coin : new Coin[] { Coin.QUARTER, Coin.DIME, Coin.NICKEL, Coin.PENNY }) {
			int coinCents = (int) Math.round(coin.getValue() * 100);
			int maxUse = available.getOrDefault(coin, 0);
			int needed = Math.min(maxUse, cents / coinCents);
			if (needed > 0) {
				result.put(coin, needed);
				cents -= needed * coinCents;
			}
		}
		return cents == 0 ? Optional.of(result) : Optional.empty();
	}
}
