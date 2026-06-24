package com.hs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {
	@Override
	public Map<String, Double> split(double totalAmount, String paidBy, List<String> participantIds) {
		double share = totalAmount / participantIds.size();
		Map<String, Double> splits = new HashMap<>();
		for (String id : participantIds) {
			splits.put(id, share);
		}
		return splits;
	}
}
