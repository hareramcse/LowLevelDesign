package com.hs;

import java.util.ArrayList;
import java.util.List;

public class GossipProtocol {
    private static GossipProtocol instance;
    private List<Node> nodes;

    private GossipProtocol() {
        nodes = new ArrayList<>();
    }

    public static synchronized GossipProtocol getInstance() {
        if (instance == null) {
            instance = new GossipProtocol();
        }
        return instance;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void connectNodes(Node node1, Node node2) {
        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
        node1.addObserver(node2);
        node2.addObserver(node1);
    }

    public void spreadGossip(Node origin, GossipMessage message) {
        origin.receiveMessage(message);
    }

    public void runGossipCycle() {
        for (Node node : nodes) {
            for (String messageContent : node.getKnownMessages()) {
                GossipMessage message = new GossipMessage(messageContent);
                node.notifyObservers(message);
            }
        }
    }
}
