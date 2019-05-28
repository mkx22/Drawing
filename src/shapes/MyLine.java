package shapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

public class MyLine extends MyShape {
    public MyLine() {

    }

    public void removeTmpshapes(MyShape myShape) {
        //异常处理或错误提示
    }

    public void addTmpshapes(MyShape myShape) {
        //异常处理或错误提示
    }

    public MyShape getChild(int i) {
        //异常处理或错误提示
        return null;
    }

    public MyLine(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name = "line";
    }

    public Shape create(double stroke) {
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStrokeWidth(stroke);
        return line;
    }

    public Shape create1(){
        return null;
    }

}
