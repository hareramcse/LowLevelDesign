package com.hs;

public class ConcreteSubscriber implements Subscriber {
	private String name;

	public ConcreteSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void onMessage(Message message) {
		System.out.println(name + " received message: " + message.getContent());
	}
}