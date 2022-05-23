package com.example.demo;

import com.example.demo.spiel.Spiel;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class SceneController {
    @FXML
    private HBox boxBeideStapel;
    @FXML
    private Button testButton;
    @FXML
    private Button ziehenButton;
    @FXML
    private HBox boxHandkarten;
    @FXML
    private Label moderationText;
    @FXML
    private Button bindButton;
    @FXML
    private Label kartenStand;
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Scene scene;
    private static Spiel spiel;
    long lastRefreshTime = 0;


    @FXML

    public void switchToGameScene (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("spielScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.addPreLayoutPulseListener(() -> {
            long refreshTime = System.nanoTime();
            //System.out.println(refreshTime - lastRefreshTime);
            lastRefreshTime = refreshTime;
        });
        stage.setScene(scene);
        stage.show();
        spiel = new Spiel(2);
    }
    public void switchToHighScoreScene (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("spielScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}