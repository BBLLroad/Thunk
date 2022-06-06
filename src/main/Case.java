package main;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Case {
    LinkedList<CaseEdge> [] adjacency_list;

    public Case() {
        adjacency_list = new LinkedList[6];
    }

    public void addClause() {
        //TODO:: make clause addition able
    }

    public void attachClauses(int source, int destination) {
        CaseEdge edge = new CaseEdge(source, destination, 1);
        adjacency_list[source].addFirst(edge);
    }
}
