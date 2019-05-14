package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class MyTriangle extends MyShape {
    private double x1, y1;
    private double x2, y2;
    private double x3, y3;

    public MyTriangle() {
        x1 = startX + (endX - startX) / 2;
        y1 = startY;
        x2 = startX;
        y2 = endY;
        x3 = endX;
        y3 = endY;
        name = "triangle";
    }

    public MyTriangle(double startX, double startY, double endX, double endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        x1 = startX + (endX - startX) / 2;
        y1 = startY;
        x2 = startX;
        y2 = endY;
        x3 = endX;
        y3 = endY;
        name = "triangle";
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }

    public double getX3() {
        return x3;
    }

    public double getY1() {
        return y1;
    }

    public double getY2() {
        return y2;
    }

    public double getY3() {
        return y3;
    }

    public Shape create() {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{x1, y1, x2, y2, x3, y3});
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeWidth(2.0);
        polygon.setFill(null);
        return polygon;
    }

    public Shape create1() {
        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(new Double[]{x1, y1, x2, y2, x3, y3});
        setName("triangle2");
        return polygon;
    }

}
