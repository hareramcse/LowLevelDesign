package com.hs;

import java.util.List;
import java.util.Map;

public class ExactSplitStrategy implements SplitStrategy {
	private final Map<String, Double> exactShares;

	public ExactSplitStrategy(Map<String, Double> exactShares) {
		this.exactShares = exactShares;
	}

	@Override
	public Map<String, Double> split(double totalAmount, String paidBy, List<String> participantIds) {
		return exactShares;
	}
}
