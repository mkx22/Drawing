package shapes;

public class MyFactory {
    public static MyShape createShape(String name, double x1, double y1, double x2, double y2) {
        MyShape myShape = null;
        switch (name) {
            case "circle":
            case "circle2":
                myShape = new MyCircle(x1, y1, x2, y2);
                break;
            case "ellipse":
            case "ellipse2":
                myShape = new MyEllipse(x1, y1, x2, y2);
                break;
            case "line":
                myShape = new MyLine(x1, y1, x2, y2);
                break;
            case "rectangle":
            case "rectangle3":
                myShape = new MyRectangle(x1, y1, x2, y2);
                break;
            case "triangle":
            case "triangle2":
                myShape = new MyTriangle(x1, y1, x2, y2);
                break;
            case "text":
                myShape = new MyText();
                break;
            case "union":
                myShape = new MyUnion(x1, y1, x2, y2);
                break;
        }
        return myShape;
    }
}
