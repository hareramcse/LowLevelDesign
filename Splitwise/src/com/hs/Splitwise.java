package com.hs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
	private final Map<String, User> users = new HashMap<>();
	// balances.get(debtor).get(creditor) = amount debtor owes creditor
	private final Map<String, Map<String, Double>> balances = new HashMap<>();

	public void addUser(User user) {
		users.put(user.id(), user);
		balances.putIfAbsent(user.id(), new HashMap<>());
	}

	public void addExpense(String paidBy, double amount, List<String> participantIds, SplitStrategy strategy) {
		Map<String, Double> splits = strategy.split(amount, paidBy, participantIds);
		for (Map.Entry<String, Double> entry : splits.entrySet()) {
			String participant = entry.getKey();
			double share = entry.getValue();
			if (!participant.equals(paidBy) && share > 0) {
				addDebt(participant, paidBy, share);
			}
		}
		System.out.println("Expense of $" + amount + " recorded. Paid by " + users.get(paidBy));
	}

	private void addDebt(String debtor, String creditor, double amount) {
		balances.putIfAbsent(debtor, new HashMap<>());
		balances.putIfAbsent(creditor, new HashMap<>());
		balances.get(debtor).merge(creditor, amount, Double::sum);
		// net against reverse debt if any
		Double reverse = balances.get(creditor).get(debtor);
		if (reverse != null && reverse > 0) {
			if (reverse >= amount) {
				balances.get(creditor).put(debtor, reverse - amount);
				balances.get(debtor).remove(creditor);
			} else {
				balances.get(debtor).put(creditor, amount - reverse);
				balances.get(creditor).remove(debtor);
			}
		}
	}

	public void printBalances() {
		System.out.println("--- Balances ---");
		for (Map.Entry<String, Map<String, Double>> entry : balances.entrySet()) {
			String debtorId = entry.getKey();
			for (Map.Entry<String, Double> debt : entry.getValue().entrySet()) {
				if (debt.getValue() > 0) {
					System.out.println(users.get(debtorId) + " owes " + users.get(debt.getKey()) + " $"
							+ debt.getValue());
				}
			}
		}
	}
}
