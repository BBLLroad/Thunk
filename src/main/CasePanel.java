package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

public class CasePanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 800;
    double x = 0;
    double y = 0;
    double[] vel = {2.0, 5.0};
    int w = 100;
    int h = 100;

    Timer timer;

    CasePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        ((FlowLayout)this.getLayout()).setVgap(0);

        timer = new Timer(10, this); //updates animation every 10ms
        timer.start();

        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try {
            Object[] vs = new Object[2];
            vs[0] = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
            vs[1] = graph.insertVertex(parent, null, "World!", 240, 150, 80, 30);
            graph.insertEdge(parent, null, "Edge", vs[0], vs[1]);

            //graph.setCellStyle("defaultVertex;fillColor=blue;fontColor=white;", vs);
            Map<String, Object> style = new HashMap<>();
            style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_RECTANGLE);
            style.put(mxConstants.STYLE_OPACITY, 50);
            style.put(mxConstants.STYLE_FONTCOLOR, "#774400");
            graph.getStylesheet().putCellStyle("ROUNDED",style);

            //graph.setCellsMovable(false);
            graph.setCellsCloneable(false);
            graph.setCellsResizable(false);
            graph.setGridEnabled(false);
        } finally {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setCenterPage(true);
        graphComponent.setPreferredSize(new Dimension(PANEL_WIDTH/2, PANEL_HEIGHT/2));
        //graphComponent.setAlignmentY(0.0f);
        this.add(graphComponent);
    }

    public void paint(Graphics g) {
        super.paint(g); //paint background

        Graphics2D g2d = (Graphics2D) g;

        //drawing of rectangle
        g2d.setColor(new Color(123, 25, 250));
        g2d.fillRect((int)x, (int)y, w, h);

        //TODO:: drawing of opinion
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //animating rectangle
        x += vel[0];
        y += vel[1];

        if (x+w >= PANEL_WIDTH || x < 0) {
            vel[0] = -vel[0];
        }
        if (y+h >= PANEL_HEIGHT || y < 0) {
            vel[1] = -vel[1];
        }

        //TODO:: animation of opinion

        repaint(); //flushes and recalls paint(g) function.
    }
}
