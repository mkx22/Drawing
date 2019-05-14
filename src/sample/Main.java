package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import shapes.MyCircle;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        DrawBoard drawBoard = new DrawBoard();

        final Scene scene = new Scene(drawBoard, 300, 275, Color.WHITE);
        drawBoard.load();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing");


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
