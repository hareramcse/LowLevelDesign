package com.hs;

public class ConcreteSubscriber implements Subscriber {
	private String name;

	public ConcreteSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void subscribe(String topicName) {
		System.out.println(name + " subscribed to topic: " + topicName);
	}

	@Override
	public void receiveMessage(Message message) {
		System.out.println(name + " received message: " + message.getContent());
	}
}