package com.hs;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
	Map<String, Double> split(double totalAmount, String paidBy, List<String> participantIds);
}
