package com.hs;

public class PubSubTest {
	public static void main(String[] args) {
		Broker broker = new Broker();
		broker.createTopic("Technology");

		Subscriber subscriber1 = new Subscriber("Subscriber 1");
		Subscriber subscriber2 = new Subscriber("Subscriber 2");
		broker.addSubscriberToTopic(subscriber1, "Technology");
		broker.addSubscriberToTopic(subscriber2, "Technology");

		broker.publish(new Message("Hello from Publisher"), "Technology");
		broker.publish(new Message("Greetings, Subscribers!"), "Technology");
	}
}
