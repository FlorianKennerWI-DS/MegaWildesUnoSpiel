package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameFX {
    private HBox playerCards = new HBox(20);
    private HBox ablegestapel = new HBox(20);
    private Hand player;

    public Parent createGamePane() {
        player = new Hand(playerCards.getChildren());
        Pane root = new Pane();
        Label moderateGame = new Label("Jij bent aan de beurt!");
        Label neighbor = new Label("Hallo :)");

        VBox rootLayout = new VBox(5);
        rootLayout.setPadding(new Insets(5, 5, 5, 5));

        rootLayout.getChildren().addAll(new HBox(moderateGame, neighbor),ablegestapel, playerCards);
        root.getChildren().addAll(rootLayout);
        return root;
    }
}
