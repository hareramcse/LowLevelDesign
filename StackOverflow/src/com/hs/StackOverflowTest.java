package com.hs;

import java.util.List;

public class StackOverflowTest {
	public static void main(String[] args) {
		StackOverflow so = new StackOverflow();
		User alice = new User("u1", "Alice");
		User bob = new User("u2", "Bob");
		so.registerUser(alice);
		so.registerUser(bob);

		Question q = so.postQuestion(alice, "How to design LRU cache?", "Looking for LLD approach.",
				List.of("java", "lld"));
		so.upvoteQuestion(q.id());

		Answer a = so.postAnswer(q.id(), bob, "Use LinkedHashMap or doubly-linked list + HashMap.");
		if (a != null) {
			so.upvoteAnswer(q.id(), a.id());
		}

		System.out.println("Search 'java': " + so.searchByTag("java"));
		System.out.println("Users: " + alice + ", " + bob);
	}
}
