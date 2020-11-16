package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


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

        HBox upperArea = new HBox();
        upperArea.setPadding(new Insets(15, 12, 15, 12));
        upperArea.setSpacing(20);
        upperArea.setStyle("-fx-background-color: #4e99e3;");

        Button insert = new Button("INSERT");
        Button delete = new Button("DELETE");
        Button reset = new Button("RESET");
        Button search = new Button("SEARCH");
        insert.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        delete.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        reset.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        search.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");

        upperArea.getChildren().addAll(insert, delete, search, reset);
        upperArea.setAlignment(Pos.CENTER);
        root.getChildren().addAll(upperArea);


        Scene scene1 = new Scene(root);


        primaryStage.setScene(scene1);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
