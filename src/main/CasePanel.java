package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mxgraph.io.mxCodec;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxUtils;
import com.mxgraph.util.mxXmlUtils;
import com.mxgraph.view.mxGraph;
import org.json.JSONException;

import org.json.JSONObject;

//import org.json.simple.JSONObject;
import org.json.XML;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;


public class CasePanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 800;
    final int PANEL_HEIGHT = 800;
    double x = 0;
    double y = 0;
    double[] vel = {2.0, 5.0};
    int w = 100;
    int h = 100;

    mxGraph graph;
    mxGraphComponent graphComponent;
    Timer timer;

    CasePanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        ((FlowLayout)this.getLayout()).setVgap(0);

        timer = new Timer(10, this); //updates animation every 10ms
        timer.start();

        graph = new mxGraph();
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

        graphComponent = new mxGraphComponent(graph);
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

    public void saveCase(String path) throws IOException {
        if (graph == null) return;

        String currentPath = new java.io.File(".").getCanonicalPath();
        path = currentPath + path;

        var encoder = new mxCodec();
        var node = encoder.encode(graph);
        String data = mxUtils.getPrettyXml(node);

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCase(String path) throws IOException, ParseException {

        String currentPath = new java.io.File(".").getCanonicalPath();
        String filePath = currentPath + path;

        mxGraph new_graph = new mxGraph();

        graph.getModel().beginUpdate();
        try {
            Document document = mxXmlUtils.parseXml(mxUtils.readFile(filePath));
            //System.out.println("Root element: " + document.getDocumentElement().getNodeName());
            //System.out.println(document.getDocumentElement().getElementsByTagName("mxGraphModel").item(0).toString());
            document.getDocumentElement().normalize();
            mxCodec codec = new mxCodec(document);
            codec.decode(document.getDocumentElement().getElementsByTagName("mxGraphModel").item(0), graph.getModel());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        graph.getModel().endUpdate();

        graphComponent.setGraph(graph);
    }
}
