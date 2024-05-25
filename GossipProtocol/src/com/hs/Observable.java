package com.hs;

public interface Observable {
    void addObserver(Node observer);
    void removeObserver(Node observer);
    void notifyObservers(GossipMessage message);
}
