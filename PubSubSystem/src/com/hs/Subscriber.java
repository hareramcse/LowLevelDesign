package com.hs;

public interface Subscriber {
    void subscribe(String topicName);
    void receiveMessage(Message message);
}
