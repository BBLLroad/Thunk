package main;

import com.sun.javafx.geom.Vec2d;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpinionPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1000;
    final int PANEL_HEIGHT = 1000;
    double x = 0;
    double y = 0;
    Vec2d vel = new Vec2d(3.0, 5.8);
    int w = 100;
    int h = 100;


    Timer timer;

    OpinionPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        timer = new Timer(10, this); //updates animation every 10ms
        timer.start();
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
        x += vel.x;
        y += vel.y;

        if (x+w >= PANEL_WIDTH || x < 0) {
            vel.x = -vel.x;
        }
        if (y+h >= PANEL_HEIGHT || y < 0) {
            vel.y = -vel.y;
        }

        //TODO:: animation of opinion

        repaint(); //flushes and recalls paint(g) function.
    }
}
