package com.example.demo;

import com.example.demo.karten.Karte;
import com.example.demo.spiel.Spiel;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SpielController  {
    @FXML
    private HBox boxBeideStapel;
    @FXML
    private Button ziehenButton;
    @FXML
    private HBox boxHandkarten;
    @FXML
    private Label moderationText;
    @FXML
    private Label kartenStand;
    @FXML
    private Stage stage;
    private Scene scene;
    private Spiel spiel;

    @FXML

    public void ziehenButton(){
        spiel.menschlicherSpielerZiehen();
        updateHandkartenView();
    }

    public void updateHandkartenView() {
        boxHandkarten.getChildren().removeAll();
        boxHandkarten.getChildren().setAll(spiel.buttonsFuerMenschlichenSpieler());
    }

/*
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spiel = new Spiel(3);
        moderationText.textProperty().bind(  spiel.aktuellerSpielerName);
        kartenStand.textProperty().bind(spiel.getKartenStand);
        boxBeideStapel.getChildren().addAll(spiel.showLetzteKarte());
        ObservableList<Node> buttonsHandkarten = spiel.buttonsFuerMenschlichenSpieler();
        Platform.runLater(()-> {
            boxHandkarten.getChildren().removeAll();
            boxHandkarten.getChildren().setAll(buttonsHandkarten);
            System.out.println("ran");
        });
        //boxHandkarten.getChildren().addAll(spiel.buttonsFuerMenschlichenSpieler());
        boxHandkarten.setSpacing(2);
    }*/
}
