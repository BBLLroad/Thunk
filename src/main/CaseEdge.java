package main;

public class CaseEdge {
    public static final double CONSISTENCY_MAX = 1.0;
    public static final double CONSISTENCY_MIN = 0.0;

    public int source;
    public int destination;

    public double consistency;

    public boolean is_to_ought; //denotes whether the connection ignores the is-ought problem

    public CaseEdge(int source, int destination, double consistency) {
        this.source = source;
        this.destination = destination;
        this.consistency = consistency;
    }
}