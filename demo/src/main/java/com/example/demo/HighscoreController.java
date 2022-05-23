package com.example.demo;

import com.example.demo.highScoreTable.HighscoreTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HighscoreController implements Initializable {

    private Stage stage;
    private Scene scene;
    @FXML
    public ListView highScoreListView;
    public Button zurueckButton;

    public void updateHighScoreListView() {
        HighscoreTable.einlesen();
        HighscoreTable.berechneDurchschnittsPosition();

        for (var entry : HighscoreTable.getAlleDurschnittsPositionen().entrySet()){
            highScoreListView.getItems().add(String.format(entry.getValue() + ": " + entry.getKey()));}
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateHighScoreListView();
    }

    public void backToStartScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("hello-view.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
