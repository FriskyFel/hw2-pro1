package pro1.swingComponents;

import pro1.drawingModel.Polyline;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private Polyline polyline = new Polyline();

    public DisplayPanel(){
        this.setBackground(Color.WHITE);
    }

    public Polyline getPolyline() {
        return polyline;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        polyline.draw((Graphics2D) g);
    }
}