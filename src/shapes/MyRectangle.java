package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class MyRectangle extends MyShape {

    private double width;
    private double height;
    private double fx;
    private double fy;

    public MyRectangle() {
        super(0, 0, 0, 0);
        double x1 = startX, x2 = endX;
        double y1 = startY, y2 = endY;
        fx = (x1 < x2) ? x1 : x2;
        fy = (y1 > y2) ? y1 : y2;
        width = Math.abs(x2 - x1);
        height = Math.abs(y2 - y1);
        name = "rectangle";
    }


    public MyRectangle(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        width = Math.abs(x2 - x1);
        height = Math.abs(y2 - y1);
        fx = Math.min(x1, x2);
        fy = Math.min(y1, y2);
        name = "rectangle";
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

    public Shape create(double stroke) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(fx);
        rectangle.setY(fy);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(stroke);
        rectangle.setFill(null);
        return rectangle;
    }

    public Shape create1() {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(fx);
        rectangle.setY(fy);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        setName("rectangle3");
        return rectangle;
    }

}
