package sample;

import btree.Operations;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;

public class Main extends Application {

    //Initializing necessary variables
    private Operations<Integer> btree = new Operations<>();
    TextField addInput = new TextField();



    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, 300, 275));

        primaryStage.setTitle("B Tree Visualizer");
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);

        //Starting VBox
        VBox root = new VBox();

        //Horizontal Box containing all buttons and input field
        HBox upperArea = new HBox();
        upperArea.setPadding(new Insets(15, 12, 15, 12));
        upperArea.setSpacing(20);
        upperArea.setStyle("-fx-background-color: #4e99e3;");

        //Buttons and input fields
        addInput.setPrefWidth(50);
        Label lbl = new Label("ENTER NODE : ");
        Button insert = new Button("INSERT");
        Button delete = new Button("DELETE");
        Button reset = new Button("RESET");
        Button search = new Button("SEARCH");
        lbl.setStyle("-fx-font-weight: bold; -fx-text-fill: white; -fx-font-size: 14");
        insert.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        delete.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        reset.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");
        search.setStyle("-fx-background-color: slateblue; -fx-text-fill: white; -fx-font-weight: bold;");

        upperArea.getChildren().addAll(lbl, addInput, insert, delete, search, reset);
        upperArea.setAlignment(Pos.CENTER);
        root.getChildren().addAll(upperArea);


        insert.setOnMouseClicked(e -> insertNode(addInput.getText()));
        delete.setOnMouseClicked(e -> deleteNode(addInput.getText()));
        search.setOnMouseClicked(e -> searchNode(addInput.getText()));
        reset.setOnMouseClicked(e -> resetTree());



        //Tree Viewing Section

        Scene scene1 = new Scene(root);

        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    private void insertNode(String s) {
        try {
            int num = Integer.parseInt(s);
            System.out.println("Node added is " + num);
            btree.add(num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format !");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input format !");
            alert.show();
        }
    }

    private void searchNode(String s) {
        try {
            int num = Integer.parseInt(s);
            System.out.println("Node searched is " + num);
            btree.add(num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format !");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input format !");
            alert.show();
        }
    }

    private void deleteNode(String s) {
        try {
            int num = Integer.parseInt(s);
            System.out.println("Node deleted is " + num);
            btree.add(num);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format !");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid input format !");
            alert.show();
        }
    }


    private void resetTree() {
        try {
            System.out.println("Tree Reset");
            addInput.setText("");
        } catch (Exception e) {
            System.out.println("Error occurred !");
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error occurred !");
            alert.show();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
