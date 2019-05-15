package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import shapes.*;

import java.util.ArrayList;

import static javafx.scene.shape.Shape.union;

public class DrawBoard extends Group {

    private double x1, y1, x2, y2;
    int copyI = -1;
    ArrayList<Shape> shapes = new ArrayList<>();
    ArrayList<MyShape> myshapes = new ArrayList<>();
    ArrayList<Integer> operates = new ArrayList<>();

    private enum Shapes {
        CIRCLE,
        ELLIPSE,
        LINE,
        RECTANGLE,
        TEXT,
        TRIANGLE;
    }

    public DrawBoard() {


    }

    public void load() {
        addToolbar();
    }

    public void addToolbar() {
        ToolBar toolBar = new ToolBar();
        addButton(toolBar, "undo");
        addButton(toolBar, "circle");
        addButton(toolBar, "circle2");
        addButton(toolBar, "ellipse");
        addButton(toolBar, "ellipse2");
        addButton(toolBar, "line");
        addButton(toolBar, "rectangle");
        addButton(toolBar, "rectangle3");
        addButton(toolBar, "triangle");
        addButton(toolBar, "triangle2");
        addButton(toolBar, "select");
        addButton(toolBar, "copy");
        addButton(toolBar, "paste");

//        copyButton(toolBar);
//        pasteButton(toolBar);
        addText(toolBar);
        getChildren().addAll(toolBar);

    }

    public void addButton(ToolBar toolBar, String string) {
        Button button = new Button("", new ImageView(new Image("image/" + string + ".png")));
        DropShadow shadow = new DropShadow();
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setEffect(shadow);
            }
        });


        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.print("\n" + string + ":\n");
                if (string == "copy") {
                    copy();
                } else if (string == "paste")
                    paste();

                else if (string == "undo")
                    undo();
                else if (string == "select")
                    select();
                else
                    getShape(string);
            }
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                button.setEffect(null);
            }
        });

        toolBar.getItems().add(button);
    }

    public void nullButton() {
        getScene().setOnMousePressed(null);
        getScene().setOnMouseReleased(null);
        getScene().setOnMouseClicked(null);
    }

    //画图
    public void getShape(String string) {
        //getShape
        getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x1 = event.getScreenX();
                y1 = event.getScreenY();
                System.out.print(" pressed:x1=" + x1);
                System.out.print(" pressed:y1=" + y1);
            }
        });

        getScene().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x2 = event.getScreenX();
                y2 = event.getScreenY();
                System.out.print(" released:x2=" + x2);
                System.out.print(" released:y2=" + y2);
                System.out.print("\n");
                draw(string, x1, y1, x2, y2, true);
                nullButton();
            }

        });


    }

    public int getIndex() {
        int index = 0;
        if (!myshapes.isEmpty()) {
            int tmpIndex = myshapes.get(myshapes.size() - 1).getIndex();
            if (myshapes.size() != operates.size()) {
                System.out.print(" Not Equal! ");
                System.out.print(" myshape: " + myshapes.size());
                System.out.print(" operates: " + operates.size() + "\n");

            }
            index = tmpIndex + operates.get(operates.size() - 1);
        }
        return index;
    }

    public void draw(String string, double x1, double y1, double x2, double y2, boolean flag) {
        System.out.print(" draw" + string + "\n");

        if (string == "circle") {
            MyCircle shape = new MyCircle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "circle2") {
            MyCircle shape = new MyCircle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "ellipse") {
            MyEllipse shape = new MyEllipse(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "ellipse2") {
            MyEllipse shape = new MyEllipse(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "line") {
            MyLine shape = new MyLine(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "rectangle") {
            MyRectangle shape = new MyRectangle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "rectangle3") {
            MyRectangle shape = new MyRectangle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "triangle") {
            MyTriangle shape = new MyTriangle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);

        } else if (string == "triangle2") {
            MyTriangle shape = new MyTriangle(x1, y1, x2, y2);
            if (flag) {
                shape.setIndex(getIndex());
                myshapes.add(shape);
            }
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        }
        if (flag) {
            operates.add(1);
        }

    }


    //文字描述
    public void addText(ToolBar toolBar) {
        TextField text = new TextField();
        text.setText("");
        text.clear();
        toolBar.getItems().add(new Label("文字描述："));
        toolBar.getItems().add(text);
    }
    //单击选中，拷贝复制

    //未组合时选中图形默认为上层图形
    public void copy() {
        getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x1 = event.getScreenX();
                y1 = event.getScreenY();
                System.out.print(" copyx1=" + x1);
                System.out.print(" copyy1=" + y1);
                int i = 0;
                for (i = shapes.size() - 1; i >= 0; i--) {

                    if (shapes.get(i).contains(x1, y1)) {
                        System.out.print(" inShape!\n");
                        copyI = i;
                        break;
                    }
                }
                if (i < 0) {
                    copyI = i;
                    System.out.print("\n");
                }
                nullButton();
            }
        });
    }

    ArrayList<MyShape> pasteArray = new ArrayList<>();

    public void paste() {
        getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //遍历operates找copyI对应的myshape中的坐标并赋值给copyI

                int start = 0, end = operates.get(0);

                for (int i = 0; i < operates.size(); i++) {

                    System.out.print(" start:" + start);
                    System.out.print(" end:" + end);
                    System.out.print(" copyI:" + copyI);
                    if (start <= copyI && copyI < end) {
                        copyI = i;
                        break;
                    } else {
//                        System.out.print(operates.size());
                        if (i + 1 < operates.size()) {
                            start = end;
                            end += operates.get(i + 1);
                        }
                    }

                }
                if (copyI > myshapes.size() - 1) {
                    System.out.print(" Error! ");
                    return;
                }
                if (copyI >= 0) {
                    //粘贴位置
                    double sx1 = event.getScreenX(), sx2 = 0;
                    double sy1 = event.getScreenY(), sy2 = 0;

                    MyShape myShape = myshapes.get(copyI);
                    double tx1 = myShape.getStartX(), ty1 = myShape.getStartY();
                    double tx2 = myShape.getEndX(), ty2 = myShape.getEndY();
                    double offx = tx2 - tx1, offy = ty2 - ty1;
                    sx2 = sx1 + offx;
                    sy2 = sy1 + offy;
                    System.out.print(" " + myShape.getName() + " ");
                    if (myShape.getName() != "union")
                        draw(myShape.getName(), sx1, sy1, sx2, sy2, true);
                    else {
                        //用draw打印
                        int i = 0;
                        // 组合中图形的位置
                        double ux1 = 0, uy1 = 0, ux2 = 0, uy2 = 0;
                        offx = sx1 - tx1;
                        offy = sy1 - ty1;

                        for (i = 0; i < pasteArray.size(); i++) {

                            myShape = pasteArray.get(i);
                            ux1 = myShape.getStartX();
                            uy1 = myShape.getStartY();
                            ux2 = myShape.getEndX();
                            uy2 = myShape.getEndY();
                            System.out.print(" " + myShape.getName() + " ");

                            draw(myShape.getName(), ux1 + offx, uy1 + offy, ux2 + offx, uy2 + offy, false);
                        }
                        //加上一个类型为union的图形
                        MyUnion myUnion = new MyUnion(sx1, sy1, sx2, sy2);
                        myUnion.setIndex(getIndex());
                        myshapes.add(myUnion);
                        operates.add(operates.get(copyI));
                    }
                    nullButton();
                }
            }
        });
    }

    //组合图形
    void select() {
        getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x1 = event.getScreenX();
                y1 = event.getScreenY();
            }
        });

        getScene().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x2 = event.getScreenX();
                y2 = event.getScreenY();
                unionShape(x1, y1, x2, y2);
                nullButton();
            }

        });
    }

    public boolean ifContain(double x1, double y1, double x2, double y2, MyShape myShape) {
        MyRectangle tmpR = new MyRectangle(x1, y1, x2, y2);
        Shape tmpS = tmpR.create1();
        String name = myShape.getName();
        double sx = myShape.getStartX(), sy = myShape.getStartY();
        double ex = myShape.getEndX(), ey = myShape.getEndY();

        if (name == "line") {
            if (tmpS.contains(sx, sy) && tmpS.contains(ex, ey))
                return true;
        } else if (name == "rectangle" || name == "rectangle3") {
            double width = Math.abs(ex - sx), height = Math.abs(ey - sy);
            double fx = Math.min(sx, ex), fy = Math.min(sy, ey);
            if (tmpS.contains(fx, fy) && tmpS.contains(fx + height, fy) &&
                    tmpS.contains(fx, fy + width) &&
                    tmpS.contains(fx + height, fy + width)) {
                return true;
            }
        } else if (name == "triangle" || name == "triangle2") {
            double tx1 = sx + (ex - sx) / 2, ty1 = sy, tx2 = sx, ty2 = ey, tx3 = ex, ty3 = ey;
            if (tmpS.contains(tx1, ty1) && tmpS.contains(tx2, ty2) && tmpS.contains(tx3, ty3))
                return true;

        } else if (name == "circle" || name == "circle2") {
            double centerX = sx + (ex - sx) / 2, centerY = sy + (ey - sy) / 2, radius = Math.abs(ex - sx) / 2;

        } else if (name == "ellipse" || name == "ellipse") {
            double centerX = sx + (ex - sx) / 2, centerY = sy + (ey - sy) / 2,
                    radiusX = Math.abs(ex - sx) / 2, radiusY = Math.abs(ey - sy) / 2;

        }
        return false;
    }


    public void unionShape(double x1, double y1, double x2, double y2) {
        int i = 0;
//        ArrayList<MyShape> tmpshapes = new ArrayList<>();
        MyRectangle myRectangle = new MyRectangle(x1, y1, x2, y2);

        //增加一个组合图形
        MyUnion myUnion = new MyUnion(x1, y1, x2, y2);

        //遍历之前的图形
        for (i = 0; i < myshapes.size(); i++) {
            MyShape myshape = myshapes.get(i);
            System.out.print(" "+myshape.getName());
            //包含该图形且非组合图形
            if (ifContain(x1, y1, x2, y2, myshape) && operates.get(i) >= 0) {
                myUnion.addTmpshapes(myshape);
                System.out.print(" Contain! " + myshape.getName() + "\n");
            }
        }
        // 没组合
        if (myUnion.getTmpshapes().isEmpty())
            return;

        //为了标识
        Shape shape = myRectangle.create1();
        shape.setStroke(Color.BLACK);
        shape.setStrokeWidth(1.0);
        shape.setFill(null);
        //getChildren().add(shape);

        // 增加进myshapes
        myUnion.setIndex(getIndex());
        // 组合选中图形，设置operates
        if (myUnion.getTmpshapes().size() != 0)
            operates.add(myUnion.getTmpshapes().size());
        else
            return;
        myshapes.add(myUnion);

        //画出组合图形
        pasteArray.clear();
        for (i = 0; i < myUnion.getTmpshapes().size(); i++) {
            MyShape tmp = myUnion.getTmpshapes().get(i);
            draw(tmp.getName(), tmp.getStartX(), tmp.getStartY(), tmp.getEndX(), tmp.getEndY(), false);
            //System.out.print(" pasteArray: add ");
            pasteArray.add(tmp);
        }

        //System.out.print(shape);

    }

    //撤销
    //也可支持多步撤销
    public void undo() {
        if (!shapes.isEmpty()) {
            for (int i = 0; i < operates.get(operates.size()-1); i++) {
                Shape shape = shapes.get(shapes.size() - 1);
                System.out.print(shape);
                shapes.remove(shapes.size() - 1);
                getChildren().remove(shape);
            }
            myshapes.remove(myshapes.size() - 1);
            operates.remove(operates.size() - 1);

        }
    }

    //扩展功能
    //拖拽-重设x2，y2，先删后建
    //getChildren().remove(node);
    //new


}
