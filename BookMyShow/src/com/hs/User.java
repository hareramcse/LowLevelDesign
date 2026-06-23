package com.hs;

public class User implements Observer {
	private final String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void update(String message) {
		System.out.println("User: " + name + " - " + message);
	}
}
