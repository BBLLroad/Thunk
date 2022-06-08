package main;

import org.jgrapht.graph.DefaultWeightedEdge;

public class CaseEdge extends DefaultWeightedEdge {
    public static final double CONSISTENCY_MAX = 1.0;
    public static final double CONSISTENCY_MIN = 0.0;

    public int source;
    public int target;

    public double weight;

    public boolean is_to_ought; //denotes whether the connection ignores the is-ought problem

    public CaseEdge(int source, int target, double weight) {
        //this.source = source;
        //this.target = target;
        this.weight = weight;
    }


}