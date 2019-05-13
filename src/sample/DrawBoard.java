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
import javafx.scene.shape.Shape;
import shapes.*;

import java.util.ArrayList;

import static javafx.scene.shape.Shape.union;

public class DrawBoard extends Group {

    private double x1, y1, x2, y2;
    int copyI = -1;
    ArrayList<Shape> shapes = new ArrayList<>();
    ArrayList<MyShape> myshapes = new ArrayList<>();
    //ArrayList<Integer> operates = new ArrayList<>();

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
        addButton(toolBar,"select");
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
                    copy(string);
                } else if (string == "paste")
                    paste(string);

                else if (string == "undo")
                    undo();
                else if(string=="select")
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
                draw(string, x1, y1, x2, y2);
                nullButton();
            }

        });


    }

    public void draw(String string, double x1, double y1, double x2, double y2) {
        System.out.print(" draw" + string + "\n");
        //operates.add(1);
        if (string == "circle") {
            MyCircle shape = new MyCircle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "circle2") {
            MyCircle shape = new MyCircle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "ellipse") {
            MyEllipse shape = new MyEllipse(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "ellipse2") {
            MyEllipse shape = new MyEllipse(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "line") {
            MyLine shape = new MyLine(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "rectangle") {
            MyRectangle shape = new MyRectangle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "rectangle3") {
            MyRectangle shape = new MyRectangle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
        } else if (string == "triangle") {
            MyTriangle shape = new MyTriangle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create();
            shapes.add(shape1);
            getChildren().add(shape1);

        } else if (string == "triangle2") {
            MyTriangle shape = new MyTriangle(x1, y1, x2, y2);
            myshapes.add(shape);
            Shape shape1 = shape.create1();
            shapes.add(shape1);
            getChildren().add(shape1);
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
    public void copy(String string) {
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

    public void paste(String string) {
        getScene().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (copyI >= 0) {
                    x1 = event.getScreenX();
                    y1 = event.getScreenY();
                    MyShape myShape = myshapes.get(copyI);
                    double tx1 = myShape.getStartX(), ty1 = myShape.getStartY();
                    double tx2 = myShape.getEndX(), ty2 = myShape.getEndY();
                    x2 = x1 + (tx2 - tx1);
                    y2 = y1 + (ty2 - ty1);
                    draw(myShape.getName(), x1, y1, x2, y2);
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
                unionShape();
                nullButton();
            }

        });
    }

    public void unionShape(){

    }

    //撤销
    //也可支持多步撤销
    public void undo() {
        if (!shapes.isEmpty()) {
            Shape shape = shapes.get(shapes.size() - 1);
            System.out.print(shape);
            shapes.remove(shapes.size() - 1);
            myshapes.remove(myshapes.size() - 1);
            //operates.remove(operates.size()-1);
            getChildren().remove(shape);

        }
    }

    //扩展功能
    //拖拽-重设x2，y2，先删后建
    //getChildren().remove(node);
    //new


}
