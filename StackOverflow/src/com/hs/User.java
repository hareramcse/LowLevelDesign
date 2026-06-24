package com.hs;

public class User {
	private final String id;
	private final String name;
	private int reputation;

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String id() {
		return id;
	}

	public String name() {
		return name;
	}

	public int reputation() {
		return reputation;
	}

	void addReputation(int points) {
		reputation += points;
	}

	@Override
	public String toString() {
		return name + " (rep " + reputation + ")";
	}
}
