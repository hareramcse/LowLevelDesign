package com.hs;

public class Customer implements Observer {
	private final String id;
	private final String name;

	public Customer(String id, String name) {
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
	public void update(String message) {
		System.out.println("Notification to " + name + ": " + message);
	}
}
