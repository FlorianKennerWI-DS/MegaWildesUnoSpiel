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
    public HBox boxBeideStapel;
    @FXML
    public Button testButton;

    public Button ziehenButton;
    public HBox boxHandkarten;
    public Label moderationText;
    public Button bindButton;
    public Label kartenStand;
    @FXML
    private Label welcomeText;
    private Stage stage;
    private Scene scene;
    private static Spiel spiel;


    @FXML

    public void switchToGameScene (ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("spielScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        spiel = new Spiel(2);
        //starteSpiel(3);
    }

    @FXML
    private void starteSpiel(int anzahlSpieler) {
        System.out.println(spiel.getSpielerName());
        bindProperties();
    }

    @FXML
    private void bindProperties() {
        moderationText.textProperty().bind(new SimpleStringProperty( "Spieler " + spiel.getSpielerName()+" ist dran"));
        kartenStand.textProperty().bind(new SimpleStringProperty(spiel.getKartenStand()));
        boxBeideStapel.getChildren().addAll(spiel.showLetzteKarte());
        boxHandkarten.getChildren().addAll(spiel.buttonsFuerMenschlichenSpieler());
        boxHandkarten.setSpacing(2);

    }

    public void ziehenButton(){
        spiel.menschlicherSpielerZiehen();
    }

}