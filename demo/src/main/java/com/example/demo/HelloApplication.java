package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Label moderateLabel;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 420);
        scene.getStylesheets().addAll(this.getClass().getResource("hello-view-style.css").toExternalForm());
        stage.setTitle("Welcome to UNO!");
        stage.setScene(scene);
        setText();
        stage.show();
    }

    private void setText() {
        moderateLabel.setText("Hallo! :)");
    }

    public static void main(String[] args) {
        launch();
    }
}