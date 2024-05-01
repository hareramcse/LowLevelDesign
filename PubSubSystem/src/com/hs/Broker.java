package com.hs;

import java.util.HashMap;
import java.util.Map;

public class Broker {
	private Map<String, Topic> topics;

	public Broker() {
		this.topics = new HashMap<>();
	}

	public void createTopic(String topicName) {
		topics.put(topicName, new ConcreteTopic(topicName));
	}

	public void addSubscriberToTopic(Subscriber subscriber, String topicName) {
		Topic topic = topics.get(topicName);
		if (topic != null) {
			topic.addSubscriber(subscriber);
		}
	}

	public void removeSubscriberFromTopic(Subscriber subscriber, String topicName) {
		Topic topic = topics.get(topicName);
		if (topic != null) {
			topic.removeSubscriber(subscriber);
		}
	}

	public void publishMessageToTopic(Message message, String topicName) {
		Topic topic = topics.get(topicName);
		if (topic != null) {
			topic.distributeMessage(message);
		}
	}
}