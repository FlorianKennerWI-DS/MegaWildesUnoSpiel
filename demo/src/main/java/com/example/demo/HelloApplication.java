package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private HBox playerCards = new HBox(20);
    private HBox ablegestapel = new HBox(20);
    private Hand player;

    public Parent createContent() {
        player = new Hand(playerCards.getChildren());
        Pane root = new Pane();
        Label moderateGame = new Label("Jij bent aan de beurt!");
        Label neighbor = new Label("Hallo :)");

        VBox rootLayout = new VBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));

        rootLayout.getChildren().addAll(new HBox(moderateGame, neighbor),ablegestapel, playerCards);
        root.getChildren().addAll(rootLayout);
        return root;

    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 420);
        scene.getStylesheets().addAll(this.getClass().getResource("hello-view-style.css").toExternalForm());
        stage.setTitle("UNO");
        stage.setScene(scene);
        stage.show();
    }

    /*public void start (Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        Button startButton = new Button("Start");

        root.getChildren().add(startButton);
        scene.getStylesheets().addAll(this.getClass().getResource("hello-view-style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }*/


    public static void main(String[] args) {
        launch();
    }
}