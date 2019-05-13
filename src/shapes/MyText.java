package shapes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MyText extends MyShape {

    String string;

    public MyText(){
        endX=20;
        endY=20;
        string="null";
    }
    public MyText(String s){
        string=s;
    }
    public Text create() {
        Text text = new Text();
        Font font = new Font(null, 32);
        text.setFont(font);
        text.setText(string);
        text.setX(endX);
        text.setY(endY);
        text.setFill(Color.RED);
        return text;
    }
}
