package com.example.demo;

import com.example.demo.highScoreTable.HighscoreTable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class HighscoreController implements Initializable {
    @FXML
    public ListView highScoreListView;

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
}
