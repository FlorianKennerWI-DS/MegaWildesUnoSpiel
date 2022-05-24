package com.example.demo;


import com.example.demo.highScoreTable.HighscoreTable;
import com.example.demo.spiel.Spiel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    public Label moderationText;
    @FXML
    private Label kartenStand;
    @FXML
    private Stage stage;
    private Scene scene;
    private Spiel spiel;

    private static String gewinner;

    public static String getGewinner() {
        return gewinner;
    }

    @FXML

    public void ziehenButton(){
        spiel.menschlicherSpielerZiehen();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spiel = new Spiel(SceneController.getSpielerZahl(), SceneController.getSpielerName());
        spiel.spielZuEnde.addListener((observableValue, aBoolean, t1) -> {
            System.out.println("fertig");
            HighscoreTable.spielAbspeichern(spiel.getSpielerListe());
            try {
                switchToEndScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //bind UI elements to observables
        moderationText.textProperty().bind(  spiel.aktuellerSpielerName);
        kartenStand.textProperty().bind(spiel.getKartenStand);
        Bindings.bindContent(boxHandkarten.getChildren(), spiel.spielerButtons);
        Bindings.bindContent(boxBeideStapel.getChildren(), spiel.spielObersteKarteBeobachten);

        boxHandkarten.setSpacing(2);
        moderationText.getScene().getStylesheets().addAll(this.getClass().getResource("startSceneStyle.css").toExternalForm());
    }

    @FXML
    public void switchToEndScene() throws IOException {
        System.out.println("wechsel");
        HighscoreTable.spielAbspeichern(spiel.getSpielerListe());
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("endScene.fxml"))));
        stage =(Stage) moderationText.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
