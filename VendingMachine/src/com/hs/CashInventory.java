package com.hs;

import java.util.EnumMap;
import java.util.Map;

public class CashInventory {
	private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

	public void stockCoins(Coin coin, int count) {
		coins.put(coin, count);
	}

	public void accept(Coin coin) {
		coins.merge(coin, 1, Integer::sum);
	}

	public int count(Coin coin) {
		return coins.getOrDefault(coin, 0);
	}

	void deduct(Map<Coin, Integer> change) {
		change.forEach((coin, qty) -> coins.merge(coin, -qty, Integer::sum));
	}

	Map<Coin, Integer> snapshot() {
		return Map.copyOf(coins);
	}
}
