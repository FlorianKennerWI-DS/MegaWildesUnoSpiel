package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class endSceneController implements Initializable {
    public Label gewinnerLabel;
    public Button zumStartBildschirm;
    public Button zurHighScoreTabelle;

    private Stage stage;

    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gewinnerLabel.setText(SpielController.getGewinner() + " hat gewonnen!");
        gewinnerLabel.setAlignment(Pos.CENTER);
    }

    public void zumStartbildSchirm(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("startScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("startSceneStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
    public void zurHighScoreTabelle(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("highScoreScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }}
