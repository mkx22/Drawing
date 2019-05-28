package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MyText extends MyShape {

    private String string;
    private Font font;
    private Color color;

    public MyText() {
        endX = 20;
        endY = 20;
        string = "null";
    }

    public MyText(String s) {
        string = s;
    }

    public void setString(String s) {
        this.string = s;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getString() {
        return string;
    }

    public Font getFont() {
        return font;
    }

    public Color getColor() {
        return color;
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

    public Text create() {
        Text text = new Text();
        Font font = new Font(null, 32);
        text.setFont(getFont());
        text.setText(getString());
        text.setX(endX);
        text.setY(endY);
        text.setFill(getColor());
        return text;
    }

    public Shape create(double stroke) {
        return null;
    }

    public Shape create1() {
        return null;
    }
}
