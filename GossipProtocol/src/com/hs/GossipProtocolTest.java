package com.hs;

public class GossipProtocolTest {
    public static void main(String[] args) {
        GossipProtocol protocol = new GossipProtocol();

        Node n1 = new Node("Node1");
        Node n2 = new Node("Node2");
        Node n3 = new Node("Node3");
        Node n4 = new Node("Node4");
        Node n5 = new Node("Node5");

        protocol.addNode(n1);
        protocol.addNode(n2);
        protocol.addNode(n3);
        protocol.addNode(n4);
        protocol.addNode(n5);

        protocol.connectNodes(n1, n2);
        protocol.connectNodes(n2, n3);
        protocol.connectNodes(n3, n4);
        protocol.connectNodes(n4, n5);
        protocol.connectNodes(n5, n1);

        protocol.spreadGossip(n1, new GossipMessage("Hello World"));

        for (int i = 0; i < 3; i++) {
            System.out.println("Gossip cycle " + (i + 1));
            protocol.runGossipCycle();
        }
    }
}
