package com.hs;

import java.util.ArrayList;
import java.util.List;

public class Topic {
	private final List<Subscriber> subscribers;

	public Topic(String name) {
		this.subscribers = new ArrayList<>();
	}

	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void publish(Message message) {
		for (Subscriber subscriber : subscribers) {
			subscriber.onMessage(message);
		}
	}
}
