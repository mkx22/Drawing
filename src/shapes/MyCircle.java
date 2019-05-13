package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.awt.*;


public class MyCircle extends MyShape {
    private double centerX;
    private double centerY;
    private double radius;

    public MyCircle(){
        centerX=startX+(endX-startX)/2;
        centerY=startY+(endY-startY)/2;
        radius=Math.abs(endX-startX)/2;
        name="circle";
    }
    public MyCircle(double x1,double y1, double x2,double y2){
        startX=x1;
        startY=y1;
        endX=x2;
        endY=y2;
        centerX=x1+(x2-x1)/2;
        centerY=y1+(y2-y1)/2;
        radius=Math.abs(x2-x1)/2;
        name="circle";
    }

    public Shape create(){
        Circle circle=new Circle();
//        System.out.print("\n"+centerX+' '+centerX+' '+radius);
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(radius);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2.0);
        circle.setFill(null);
        return circle;
    }
    public Shape create1(){
        Circle circle=new Circle();
//        System.out.print("\n"+centerX+' '+centerX+' '+radius);
        circle.setCenterX(centerX);
        circle.setCenterY(centerY);
        circle.setRadius(radius);
        setName("circle2");
//        circle.setStroke(Color.RED);
        return circle;
    }

}
