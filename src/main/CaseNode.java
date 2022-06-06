package main;

public class CaseNode {
    public enum NodeType {
        CLAUSE,
        ASSUMPTION,
        DEFINITION,
        SLIDER,
    }

    public static final double SLIDER_MAX = 1.0;
    public static final double SLIDER_MIN = 0.0;

    public String content;
    public NodeType type;

    //variables exclusive to slider type
    public double slider_value;

    //variables exclusive to definition type
    public String word;

    public boolean is_moral;
}
