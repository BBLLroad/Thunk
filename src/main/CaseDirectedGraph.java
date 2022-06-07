package main;

import java.awt.*;
import java.util.LinkedList;
import java.util.Map;

class CaseDirectedGraph {
    private Map<CaseNode, LinkedList<CaseNode>> adjacency_list;

    void addNode(String label) {
        adjacency_list.putIfAbsent(new CaseNode(label), new LinkedList<>());
    }

    void removeNode(String content) {
        CaseNode node = new CaseNode(content);
        adjacency_list.values().stream().forEach(e -> e.remove(node));
        adjacency_list.remove(new CaseNode(content));
    }

    void addEdge(String content1, String content2) {
        CaseNode node1 = new CaseNode(content1);
        CaseNode node2 = new CaseNode(content2);
        adjacency_list.get(node1).add(node2);
    }

    void removeEdge(String content1, String content2) {
        CaseNode node1 = new CaseNode(content1);
        CaseNode node2 = new CaseNode(content2);
        LinkedList<CaseNode> adj_entry = adjacency_list.get(node1);
        if (adj_entry != null)
            adj_entry.remove(node2);
    }

    LinkedList<CaseNode> getAdjacentNodes(String content) {
        return adjacency_list.get(new CaseNode(content));
    }
}
