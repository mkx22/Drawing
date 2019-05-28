package shapes;

import javafx.scene.shape.*;

//三角形、方框、圆形、椭圆、连接线
public abstract class MyShape {
    //鼠标记录开始坐标及结束坐标
    protected double startX;
    protected double startY;
    protected double endX;
    protected double endY;
    protected String name;
    protected int index;
    protected double stroke;

    public MyShape() {
        startX = 0;
        startY = 0;
        endX = 0;
        endY = 0;
        name = "name";
        stroke = 2.0;
    }

    public MyShape(double x1, double y1, double x2, double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name = "name";
        stroke = 2.0;
    }

    public abstract void removeTmpshapes(MyShape myShape);
    public abstract void addTmpshapes(MyShape myShape);
    public abstract MyShape getChild(int i);

    //画图
    public abstract Shape create(double stroke);
//    {
//        return null;
//    }
    public abstract Shape create1();
//    {
//        return null;
//    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public String getName() {
        return name;
    }


    public void setName(String name1) {
        name = name1;
    }


    public void setIndex(int index1) {
        index = index1;
    }

    public int getIndex() {
        return index;
    }
}

