package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;

    public MainFrame() {
        this.setTitle("PRO1 Drawing");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 0));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        this.add(leftPanel, BorderLayout.WEST);

        JSlider slider = new JSlider(1, 20, 2);
        slider.addChangeListener(e -> {
            displayPanel.getPolyline().setThickness(slider.getValue());
            displayPanel.repaint();
        });
        leftPanel.add(new JLabel("Thickness"));
        leftPanel.add(slider);

        JCheckBox checkBox = new JCheckBox("Red", true);
        checkBox.addActionListener(e -> {
            displayPanel.getPolyline().setRed(checkBox.isSelected());
            displayPanel.repaint();
        });
        leftPanel.add(checkBox);

        JButton reset = new JButton("Reset");
        reset.addActionListener(e -> {
            displayPanel.getPolyline().reset();
            displayPanel.repaint();
        });
        leftPanel.add(reset);

        this.displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                displayPanel.getPolyline().addPoint(e.getX(), e.getY());
                displayPanel.repaint();
            }
        });

        this.setVisible(true);
    }
}