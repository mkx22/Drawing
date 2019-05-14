package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;


public class MyEllipse extends MyShape {
    private double centerX;
    private double centerY;
    private double radiusX;
    private double radiusY;

    public MyEllipse() {
        centerX = startX + (endX - startX) / 2;
        centerY = startY + (endY - startY) / 2;
        radiusX = Math.abs(endX - startX) / 2;
        radiusY = Math.abs(endY - startY) / 2;
        name = "ellipse";
    }

    public MyEllipse(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        centerX = x1 + (x2 - x1) / 2;
        centerY = y1 + (y2 - y1) / 2;
        radiusX = Math.abs(x2 - x1) / 2;
        radiusY = Math.abs(y2 - y1) / 2;
        name = "ellipse";
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadiusX() {
        return radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    public Shape create() {
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(centerX);
        ellipse.setCenterY(centerY);
        ellipse.setRadiusX(radiusX);
        ellipse.setRadiusY(radiusY);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(2.0);
        ellipse.setFill(null);
        return ellipse;
    }

    public Shape create1() {
        Ellipse ellipse = new Ellipse();
        ellipse.setCenterX(centerX);
        ellipse.setCenterY(centerY);
        ellipse.setRadiusX(radiusX);
        ellipse.setRadiusY(radiusY);
        setName("ellipse2");
        return ellipse;
    }

}
