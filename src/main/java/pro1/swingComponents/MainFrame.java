package pro1.swingComponents;

import pro1.drawingModel.Drawable;
import pro1.drawingModel.Group;
import pro1.drawingModel.Rectangle;
import pro1.drawingModel.Text;
import pro1.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    DisplayPanel displayPanel;

    public MainFrame() {
        setTitle("PRO1 Drawing");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        displayPanel = new DisplayPanel();
        add(displayPanel, BorderLayout.CENTER);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(
                new Dimension(200, 0));
        add(leftPanel, BorderLayout.WEST);

        displayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                displayPanel.setDrawable(example(e.getX(), e.getY()));
            }
        });
    }

    private Drawable example(int x, int y) {
        var color = ColorUtils.randomColor();
        var d1 = new Rectangle(0, 0, 150, 250, color);
        var d2 = new Text(0, 0, color);
        return new Group(new Drawable[]{d1, d2}, x, y, 40, 1, 1);
    }
}