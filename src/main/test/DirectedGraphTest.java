package main.test;

import main.CaseNode;
import main.CaseEdge;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.jgrapht.*;
import org.jgrapht.graph.*;
//import org.jgrapht.traverse.*;


/**
 * Basic Test suite for JGraphT's subclass Graph "simpleDirectedWeightedGraph" functionality
 */
public class DirectedGraphTest {
    Graph<CaseNode, CaseEdge> g;

    @BeforeTest
    public void setUp() {
        g = new SimpleDirectedWeightedGraph<>(CaseEdge.class);
    }

    @Test
    public void testAddNodeSimple() {
        CaseNode node1 = new CaseNode("content");

        g.addVertex(node1);

        Assert.assertTrue(g.containsVertex(node1));
    }

    @Test
    public void testRemoveNodeSimple() {
        CaseNode node1 = new CaseNode("content");

        g.addVertex(node1);

        Assert.assertTrue(g.containsVertex(node1));

        g.removeVertex(node1);

        Assert.assertFalse(g.containsVertex(node1));
    }

    @Test
    public void testAddEdgeSimple() {
        CaseNode node1 = new CaseNode("content");
        CaseNode node2 = new CaseNode("content");

        g.addVertex(node1);
        g.addVertex(node2);

        g.addEdge(node1, node2, new CaseEdge(0, 0, 0.5));

        Assert.assertTrue(g.containsEdge(node1, node2));
    }

    @Test
    public void testRemoveEdgeSimple() {
        CaseNode node1 = new CaseNode("content");
        CaseNode node2 = new CaseNode("content");

        g.addVertex(node1);
        g.addVertex(node2);

        g.addEdge(node1, node2, new CaseEdge(0, 0, 0.5));

        Assert.assertTrue(g.containsEdge(node1, node2));

        g.removeEdge(node1, node2);

        Assert.assertFalse(g.containsEdge(node1, node2));
    }
}
