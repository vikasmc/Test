package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

public class Node {

    private boolean inbound;
    private int vlaue;
    private List<Node> adjacentNodes;
    public Node(int vlaue) {
        this.inbound = false;
        this.vlaue= vlaue;
    }

    public boolean isInbound() {
        return inbound;
    }

    public void setInbound(boolean inbound) {
        this.inbound = inbound;
    }

    public List<Node> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addNode(Node node) {
        if (this.adjacentNodes == null) {
            this.adjacentNodes = new ArrayList<>();
        }
        this.adjacentNodes.add(node);
        node.setInbound(true);
    }

    public int getVlaue() {
        return vlaue;
    }

    public void setVlaue(int vlaue) {
        this.vlaue = vlaue;
    }
}
