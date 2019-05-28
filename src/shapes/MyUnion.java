package shapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class MyUnion extends MyShape {
    private int index;
    ArrayList<MyShape> tmpshapes = new ArrayList<>();

    public MyUnion() {

    }

    public MyUnion(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name = "union";
    }

    public Shape create(double stroke) {
        return null;
    }

    public Shape create1() {
        return null;
    }

    public void removeTmpshapes(MyShape myShape) {
        tmpshapes.remove(myShape);
    }

    public void addTmpshapes(MyShape myShape) {
        tmpshapes.add(myShape);
    }

    public MyShape getChild(int i) {
        return (MyShape) tmpshapes.get(i);
    }

    public ArrayList<MyShape> getTmpshapes() {
        return tmpshapes;
    }
}
