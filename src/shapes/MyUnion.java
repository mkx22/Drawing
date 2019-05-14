package shapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class MyUnion extends MyShape{
    private int index;
    ArrayList<MyShape> tmpshapes = new ArrayList<>();

    public MyUnion(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name = "union";
    }
    public void addTmpshapes(MyShape myShape){
        tmpshapes.add(myShape);
    }
    public ArrayList<MyShape> getTmpshapes(){
        return tmpshapes;
    }
}
