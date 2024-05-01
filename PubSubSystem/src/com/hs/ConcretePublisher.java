package com.hs;

public class ConcretePublisher implements Publisher {
	private Broker broker;

	public ConcretePublisher(Broker broker) {
		this.broker = broker;
	}

	@Override
	public void publishMessage(Message message, String topicName) {
		broker.publishMessageToTopic(message, topicName);
	}
}
