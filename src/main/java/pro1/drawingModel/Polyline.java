package pro1.drawingModel;

import java.awt.*;
import java.util.ArrayList;

public class Polyline implements Drawable {

    private ArrayList<Point> points = new ArrayList<>();
    private int thickness = 2;
    private boolean red = true;

    public void addPoint(int x, int y) {
        points.add(new Point(x, y));
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void reset() {
        points.clear();
    }

    @Override
    public void draw(Graphics2D g) {

        if (points.size() < 2) return;

        g.setStroke(new BasicStroke(thickness));
        g.setColor(red ? Color.RED : Color.GRAY);

        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (Point p : points) {
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }

        g.setColor(Color.RED);
        g.drawRect(minX, minY, maxX - minX, maxY - minY);
    }
}