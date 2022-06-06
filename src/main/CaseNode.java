package main;

public class CaseNode {
    enum NodeType {
        CLAUSE,
        ASSUMPTION,
        DEFINITION,
        SLIDER,
    }

    public String clause;
    public NodeType type;
    public boolean is_moral;
}
