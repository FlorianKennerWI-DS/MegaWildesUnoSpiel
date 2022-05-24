package com.example.demo;


import com.example.demo.highScoreTable.HighscoreTable;
import com.example.demo.spiel.Spiel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.beans.binding.Bindings;
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
    //wir haben in den meisten Faellen dieses Interface implementiert, um die initialize-Methode verwenden zu koennen

    public Label letzteAktion;
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

        //zur EndScene wechseln, sobald Spiel zu Ende ist
        spiel.spielZuEnde.addListener((observableValue, aBoolean, t1) -> {
            gewinner = HighscoreTable.spielAbspeichern(spiel.getSpielerListe());
            try {
                switchToEndScene();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //UI Elemente an Observables binden, damit UI aktuell bleibt
        moderationText.textProperty().bind(  spiel.aktuellerSpielerName);
        kartenStand.textProperty().bind(spiel.getKartenStand);
        Bindings.bindContent(boxHandkarten.getChildren(), spiel.spielerButtons);
        Bindings.bindContent(boxBeideStapel.getChildren(), spiel.spielObersteKarteBeobachten);

        boxHandkarten.setSpacing(2);

        letzteAktion.textProperty().bind(spiel.letzteAktionUndKarte);
    }

    @FXML
    public void switchToEndScene() throws IOException {
        HighscoreTable.spielAbspeichern(spiel.getSpielerListe());
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("endScene.fxml"))));
        stage =(Stage) moderationText.getScene().getWindow(); //auf aktuelle Scene zugreifen
        scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("endSceneStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
