package com.hs;

import java.util.HashSet;
import java.util.Set;

public class Node implements Observable {
    private String id;
    private Set<String> knownMessages;
    private Set<Node> neighbors;
    private Set<Node> observers;

    public Node(String id) {
        this.id = id;
        this.knownMessages = new HashSet<>();
        this.neighbors = new HashSet<>();
        this.observers = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public Set<String> getKnownMessages() {
        return knownMessages;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public Set<Node> getNeighbors() {
        return neighbors;
    }

    public void receiveMessage(GossipMessage message) {
        if (knownMessages.add(message.getContent())) {
            System.out.println("Node " + id + " received new message: " + message.getContent());
            notifyObservers(message);
        }
    }

    @Override
    public void addObserver(Node observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Node observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(GossipMessage message) {
        for (Node observer : observers) {
            observer.receiveMessage(message);
        }
    }
}
