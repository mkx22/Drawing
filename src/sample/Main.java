package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.loadBoard(getClass().getResource("sample.fxml"));


        DrawBoard drawBoard = new DrawBoard();

        final Scene scene = new Scene(drawBoard, 300, 275, Color.WHITE);

        drawBoard.loadBoard(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Drawing");


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
