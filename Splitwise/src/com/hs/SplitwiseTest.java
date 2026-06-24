package com.hs;

import java.util.List;
import java.util.Map;

public class SplitwiseTest {
	public static void main(String[] args) {
		Splitwise splitwise = new Splitwise();
		User alice = new User("u1", "Alice");
		User bob = new User("u2", "Bob");
		User charlie = new User("u3", "Charlie");
		splitwise.addUser(alice);
		splitwise.addUser(bob);
		splitwise.addUser(charlie);

		// Alice paid $300 dinner split equally among 3
		splitwise.addExpense("u1", 300, List.of("u1", "u2", "u3"), new EqualSplitStrategy());

		// Bob paid $100 taxi; exact split: Bob $40, Alice $30, Charlie $30
		splitwise.addExpense("u2", 100, List.of("u1", "u2", "u3"),
				new ExactSplitStrategy(Map.of("u1", 30.0, "u2", 40.0, "u3", 30.0)));

		splitwise.printBalances();
	}
}
