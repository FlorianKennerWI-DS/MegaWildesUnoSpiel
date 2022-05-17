package com.example.demo;

import javafx.scene.Parent;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class MenuFX {
    Pane startRoot;

    private Parent createStartPane() {
        startRoot = new AnchorPane();
        MenuButton amountOfPlayers = new MenuButton("Select Amount of Players!");

        //set background
        Image img = new Image("background.png");
        BackgroundImage backgroundImage = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        startRoot.setBackground(new Background(backgroundImage));

        startRoot.getChildren().addAll(amountOfPlayers);
        return startRoot;
    }

    public Parent getPane() {
        return startRoot;
    }
}
