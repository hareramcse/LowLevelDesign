package com.hs;

/** Subscriber receives messages published to a topic. */
public class Subscriber {
	private final String name;

	public Subscriber(String name) {
		this.name = name;
	}

	public void onMessage(Message message) {
		System.out.println(name + " received message: " + message.getContent());
	}
}
