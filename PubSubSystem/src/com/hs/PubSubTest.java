package com.hs;

public class PubSubTest {
	public static void main(String[] args) {
		Broker broker = new Broker();

		broker.createTopic("Technology");

		ConcreteSubscriber subscriber1 = new ConcreteSubscriber("Subscriber 1");
		ConcreteSubscriber subscriber2 = new ConcreteSubscriber("Subscriber 2");

		broker.addSubscriberToTopic(subscriber1, "Technology");
		broker.addSubscriberToTopic(subscriber2, "Technology");

		ConcretePublisher publisher = new ConcretePublisher(broker);

		Message message1 = new Message("Hello from Publisher");
		Message message2 = new Message("Greetings, Subscribers!");

		publisher.publish(message1, "Technology");
		publisher.publish(message2, "Technology");
	}
}
