package com.hs;

public class Test {
	public static void main(String[] args) {
        GossipProtocol protocol = GossipProtocol.getInstance();

        Node node1 = new Node("Node1");
        Node node2 = new Node("Node2");
        Node node3 = new Node("Node3");
        Node node4 = new Node("Node4");
        Node node5 = new Node("Node5");

        protocol.addNode(node1);
        protocol.addNode(node2);
        protocol.addNode(node3);
        protocol.addNode(node4);
        protocol.addNode(node5);

        protocol.connectNodes(node1, node2);
        protocol.connectNodes(node2, node3);
        protocol.connectNodes(node3, node4);
        protocol.connectNodes(node4, node5);
        protocol.connectNodes(node5, node1);

        GossipMessage initialMessage = new GossipMessage("Hello World");
        protocol.spreadGossip(node1, initialMessage);

        for (int i = 0; i < 5; i++) {
            System.out.println("Running gossip cycle " + (i + 1));
            protocol.runGossipCycle();
        }
    }

}
