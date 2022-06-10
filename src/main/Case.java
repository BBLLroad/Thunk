package main;

import com.mxgraph.view.mxGraph;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import java.awt.*;
import java.util.LinkedList;


public class Case {
    mxGraph graph = new mxGraph();

    public Case() {
        //graph = new SimpleDirectedWeightedGraph<>(CaseEdge.class);
        //CaseNode default_node = new CaseNode("default content");
        //graph.addVertex(default_node);
    }
}
