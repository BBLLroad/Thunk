package main;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.awt.*;
import java.util.LinkedList;


public class Case {
    Graph<CaseNode, CaseEdge> g;

    public Case() {
        g = new SimpleDirectedWeightedGraph<>(CaseEdge.class);
        CaseNode default_node = new CaseNode("default content");
        g.addVertex(default_node);
    }
}
