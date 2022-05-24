package com.example.demo;


import com.example.demo.spiel.Spiel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

// Malena und Florian
public class SpielController  implements Initializable{
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
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spiel = new Spiel(SceneController.getSpielerZahl(), SceneController.getSpielerName());

        //bind UI elements to observables
        moderationText.textProperty().bind(  spiel.aktuellerSpielerName);
        kartenStand.textProperty().bind(spiel.getKartenStand);
        Bindings.bindContent(boxHandkarten.getChildren(), spiel.spielerButtons);
        Bindings.bindContent(boxBeideStapel.getChildren(), spiel.spielObersteKarteBeobachten);

        boxHandkarten.setSpacing(2);
    }
}
