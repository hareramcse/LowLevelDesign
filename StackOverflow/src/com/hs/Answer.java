package com.hs;

public class Answer {
	private final String id;
	private final String body;
	private final User author;
	private int votes;

	public Answer(String id, String body, User author) {
		this.id = id;
		this.body = body;
		this.author = author;
	}

	public String id() {
		return id;
	}

	public User author() {
		return author;
	}

	public int votes() {
		return votes;
	}

	void upvote() {
		votes++;
		author.addReputation(10);
	}

	@Override
	public String toString() {
		return "[" + votes + " votes] " + body + " by " + author.name();
	}
}
