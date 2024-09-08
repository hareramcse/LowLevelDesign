package com.hs;

public class ConcretePublisher implements Publisher {
	private Broker broker;

	public ConcretePublisher(Broker broker) {
		this.broker = broker;
	}

	@Override
	public void publish(Message message, String topicName) {
		broker.publish(message, topicName);
	}
}
