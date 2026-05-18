package com.hs;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
	private String name;
	private List<Subscriber> subscribers;

	public Topic(String name) {
		this.name = name;
		this.subscribers = new CopyOnWriteArrayList<>();
	}

	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	public void publish(Message message) {
		for (Subscriber subscriber : subscribers) {
			subscriber.onMessage(message);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}