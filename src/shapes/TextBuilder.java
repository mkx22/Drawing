package shapes;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextBuilder {
    MyText myText;

    public TextBuilder() {
        myText = new MyText();
    }

    public void buildFont() {
        myText.setFont(Font.font(1));
    }

    public void buildText() {
        myText.setString("一句话");
    }

    public void buildColor() {
        myText.setColor(Color.RED);
    }

    public MyText builderText() {
        buildColor();
        buildFont();
        buildText();
        return myText;
    }
}
