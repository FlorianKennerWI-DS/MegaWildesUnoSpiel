package com.example.demo;

import com.example.demo.player.Card;
import com.example.demo.player.CardVisible;
import com.example.demo.player.Hand;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {

    private HBox playerCards = new HBox(20);
    private HBox ablegestapel = new HBox(20);
    private Hand player;
    Label moderateGame;

    public Parent createGamePane() {
        player = new Hand(playerCards.getChildren());
        player.takeCard(new CardVisible(Color.BLUE, 2));
        Pane root = new Pane();
        moderateGame = new Label("Jij bent aan de beurt!");
        Label ziehstapel = new Label("Ziehstapel :)"); //replace with HBox

        VBox rootLayout = new VBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));

        rootLayout.getChildren().addAll(moderateGame,new HBox(ziehstapel, ablegestapel), playerCards);
        root.getChildren().addAll(rootLayout); //add background
        return root;
    }

    private Parent createStartPane() {
        Pane startRoot = new AnchorPane();
        MenuButton amountOfPlayers = new MenuButton("Select Amount of Players!");

        //set background
        Image img = new Image(GameApplication.class.getResourceAsStream("background.png"));
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        startRoot.setBackground(new Background(backgroundImage));

        Button startButton = new Button("Start!");
        startButton.setOnAction((event) -> {
            Stage stage =(Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(createGamePane(), 600 ,420));
        });

        startRoot.getChildren().addAll(amountOfPlayers, startButton);
        return startRoot;
    }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createStartPane(), 600, 420);
        stage.setTitle("UNO");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}