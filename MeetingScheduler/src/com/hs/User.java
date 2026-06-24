package com.hs;

public class User {
	private final String id;
	private final String name;

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

	@Override
	public String toString() {
		return name;
	}
}
