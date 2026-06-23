package com.hs;

import java.util.ArrayList;
import java.util.List;

public class GossipProtocol {
    private final List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void connectNodes(Node a, Node b) {
        a.addNeighbor(b);
        b.addNeighbor(a);
    }

    public void spreadGossip(Node origin, GossipMessage message) {
        origin.receiveMessage(message);
    }

    public void runGossipCycle() {
        for (Node node : nodes) {
            for (String content : node.knownMessages()) {
                node.receiveMessage(new GossipMessage(content));
            }
        }
    }
}
