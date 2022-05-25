package com.example.demo;

import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

// Malena
public class SceneController implements Initializable {
    public TextField nameFeld;
    public ChoiceBox spielerZahlChoiceBox ;
    public Label mitspielerLabel;
    public Button startButton;
    private Stage stage;
    private Scene scene;

    private static int spielerZahl;
    private static String spielerName;
    public static int getSpielerZahl() {
        return spielerZahl;
    }
    public static String getSpielerName() {
        return spielerName;
    }

    @FXML

    public void switchToGameScene (ActionEvent event) throws IOException {
        setSpielerZahlundName();
        Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("spielScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("spielSceneStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
    public void switchToHighScoreScene (ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load((Objects.requireNonNull(getClass().getResource("highScoreScene.fxml"))));
        stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setSpielerZahlundName() {
        spielerName = nameFeld.getText().trim();
        spielerName = spielerName.substring(0, 1).toUpperCase() + spielerName.substring(1);
        spielerZahl = (int ) spielerZahlChoiceBox.getValue();
        System.out.println(spielerName);
        System.out.println(spielerZahl);
        //

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        spielerZahlChoiceBox.getItems().add(1);
        spielerZahlChoiceBox.getItems().add(2);
        spielerZahlChoiceBox.getItems().add(3);
        spielerZahlChoiceBox.getItems().add(4);
        spielerZahlChoiceBox.getItems().add(5);

        //man kann Spiel erst starten, wenn Anzahl der Gegenspieler ausgewaehlt
        BooleanBinding startDiabled = spielerZahlChoiceBox.getSelectionModel().selectedItemProperty().isNull();
        startButton.disableProperty().bind(startDiabled);
        //mitspielerLabel.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, CornerRadii.EMPTY, Insets.EMPTY)));;
    }
}