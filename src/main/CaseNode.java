package main;

import java.io.Serializable;
import java.util.Objects;

public class CaseNode implements Serializable {
    public enum NodeType {
        CLAUSE,
        ASSUMPTION,
        DEFINITION,
        SLIDER,
        ARCHIVED
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

    public CaseNode() {
        this.content = "default content";
    }

    public CaseNode(String content) {
        this.content = content;
    }

    public CaseNode(String content, NodeType type, double slider_value, String word) {
        this.content = content;
        this.type = type;
        this.slider_value = slider_value;
        this.word = word;

        this.is_moral = false; //TODO:: assess if newly-made node is a moral statement
    }

    @Override
    public String toString() {
        if (GUIConstants.SHOW_NODE_LABEL) {
            return content;
        } else {
            return null;
        }
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseNode caseNode = (CaseNode) o;
        return Double.compare(caseNode.slider_value, slider_value) == 0
                && is_moral == caseNode.is_moral
                && Objects.equals(content, caseNode.content)
                && type == caseNode.type && Objects.equals(word, caseNode.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, type, slider_value, word, is_moral);
    }*/
}
