package shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MyText extends MyShape {

    String string;

    public MyText() {
        endX = 20;
        endY = 20;
        string = "null";
    }

    public MyText(String s) {
        string = s;
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

    //    public Text create() {
//        Text text = new Text();
//        Font font = new Font(null, 32);
//        text.setFont(font);
//        text.setText(string);
//        text.setX(endX);
//        text.setY(endY);
//        text.setFill(Color.RED);
//        return text;
//    }
    public Shape create(double stroke) {
        return null;
    }

    public Shape create1(){
        return null;
    }
}
