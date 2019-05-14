package shapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class MyLine extends MyShape {
    public MyLine(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name = "line";
    }

    public Shape create() {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStrokeWidth(2.0);
        return line;
    }

}
