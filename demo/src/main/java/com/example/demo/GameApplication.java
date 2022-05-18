package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    private HBox playerCards = new HBox(20);
    private HBox ablegestapel = new HBox(20);
    private Hand player;
    private Stage primaryStage;

    public Parent createGamePane() {
        player = new Hand(playerCards.getChildren());
        Pane root = new Pane();
        Label moderateGame = new Label("Jij bent aan de beurt!");
        Label ziehstapel = new Label("Ziehstapel :)");

        VBox rootLayout = new VBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));

        rootLayout.getChildren().addAll(moderateGame,new HBox(ziehstapel, ablegestapel), playerCards);
        root.getChildren().addAll(rootLayout);
        return root;
    }

    private Parent createStartPane(Stage stage) {
        Pane startRoot = new AnchorPane();
        MenuButton amountOfPlayers = new MenuButton("Select Amount of Players!");

        //set background
        Image img = new Image("..\\..\\..\\..\\resources\\com\\example\\demo\\background.png"); //throws error if non-absolute path
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        startRoot.setBackground(new Background(backgroundImage));

        Button startButton = new Button("Start!");
        startButton.setOnAction((event) -> stage.setScene(new Scene(createGamePane(), 600 ,420)));

        startRoot.getChildren().addAll(amountOfPlayers, startButton);
        return startRoot;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createStartPane(stage), 600, 420);
        //Karten austeilen
        stage.setTitle("UNO");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}