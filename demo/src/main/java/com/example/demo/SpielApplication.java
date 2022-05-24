package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

// Malena
public class SpielApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SpielApplication.class.getResource("startScene.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, 600, 420);
        scene.getStylesheets().addAll(this.getClass().getResource("startSceneStyle.css").toExternalForm());
        stage.setTitle("Lets play UNO!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}