package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.shape.Polygon;

import static javafx.application.Application.launch;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setTitle("B Tree Visualizer");

        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        VBox root = new VBox();

        Label label1 = new Label("This is a text label");
        root.getChildren().add(label1);

        Scene scene1 = new Scene(root);


        primaryStage.setScene(scene1);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
