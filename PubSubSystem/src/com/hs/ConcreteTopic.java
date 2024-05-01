package com.hs;

import java.util.ArrayList;
import java.util.List;

public class ConcreteTopic implements Topic {
	private String name;
	private List<Subscriber> subscribers;

	public ConcreteTopic(String name) {
		this.name = name;
		this.subscribers = new ArrayList<>();
	}

	@Override
	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	@Override
	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}

	@Override
	public void distributeMessage(Message message) {
		for (Subscriber subscriber : subscribers) {
			subscriber.receiveMessage(message);
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}