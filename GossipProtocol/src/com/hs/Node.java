package com.hs;

import java.util.HashSet;
import java.util.Set;

public class Node {
    private final String id;
    private final Set<String> knownMessages = new HashSet<>();
    private final Set<Node> neighbors = new HashSet<>();

    public Node(String id) {
        this.id = id;
    }

    public Set<String> knownMessages() { return knownMessages; }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public void receiveMessage(GossipMessage message) {
        if (knownMessages.add(message.content())) {
            System.out.println("Node " + id + " received: " + message.content());
            neighbors.forEach(n -> n.receiveMessage(message));
        }
    }
}
