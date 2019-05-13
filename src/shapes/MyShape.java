package shapes;

import javafx.scene.shape.*;

//三角形、方框、圆形、椭圆、连接线
public class MyShape {
    //鼠标记录开始坐标及结束坐标
    protected double startX;
    protected double startY;
    protected double endX;
    protected double endY;
    protected String name;

    public MyShape(){
        startX=0;
        startY =0;
        endX =0;
        endY =0;
        name="name";
    }

    public MyShape(double x1,double y1,double x2,double y2) {
        startX = x1;
        startY = y1;
        endX = x2;
        endY = y2;
        name="name";
    }

    //画图
    public Shape create() { return null; }

    public double getStartX(){
        return startX;
    }

    public double getStartY(){
        return startY;
    }

    public double getEndX(){
        return endX;
    }

    public double getEndY(){
        return endY;
    }

    public String getName(){
        return name;
    }

    public void setName(String name1){
        name=name1;
    }
    public void setStartX(double x){
        startX=x;
    }

    public void setStartY(double y){
        startY =y;
    }

    public void setEndX(double x){
        endX =x;
    }

    public void setEndY(double y){
        endY =y;
    }
}
