package com.hs;

public interface Topic {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void distributeMessage(Message message);
}