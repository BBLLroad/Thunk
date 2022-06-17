package main;

import com.formdev.flatlaf.FlatDarkLaf;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {

    private JButton button_msg;
    private JPanel panel_main;
    private JPanel panel_case;
    private JPanel panel_sidebar;
    private JButton button_save;
    private JButton button_load;

    public App() {
        button_msg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello World!");
            }
        });
        button_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "/src/main/test/example_jsons/example1.txt";

                CasePanel cp = (CasePanel) panel_case;
                try {
                    cp.saveCase(path);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        button_load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "/src/main/test/example_jsons/example1.txt";

                CasePanel cp = (CasePanel) panel_case;
                try {
                    cp.loadCase(path);
                } catch (IOException | ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        JFrame frame = new JFrame("App");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setContentPane(new App().panel_main);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public void createUIComponents() {
        panel_case = new CasePanel();
    }
}
