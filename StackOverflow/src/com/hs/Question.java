package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private final String id;
	private final String title;
	private final String body;
	private final User author;
	private final List<String> tags = new ArrayList<>();
	private int votes;
	private final List<Answer> answers = new ArrayList<>();

	public Question(String id, String title, String body, User author) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public String id() {
		return id;
	}

	public String title() {
		return title;
	}

	public User author() {
		return author;
	}

	public List<String> tags() {
		return tags;
	}

	public int votes() {
		return votes;
	}

	public List<Answer> answers() {
		return answers;
	}

	void addTag(String tag) {
		tags.add(tag);
	}

	void upvote() {
		votes++;
		author.addReputation(5);
	}

	void addAnswer(Answer answer) {
		answers.add(answer);
	}

	@Override
	public String toString() {
		return "[" + votes + " votes] " + title + " by " + author.name() + " tags=" + tags;
	}
}
