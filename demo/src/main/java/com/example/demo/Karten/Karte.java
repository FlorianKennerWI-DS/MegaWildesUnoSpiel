package com.example.demo.Karten;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;

public class Karte {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 140;
    Color farbe;
    int zahl;

    public Karte (Color farbe, int zahl) {
        this.farbe = farbe;
        this.zahl =  zahl;
        Rectangle bg = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(farbe);

        Text text1 = new Text(Integer.toString(zahl));
        text1.setFont(Font.font(18));
        text1.setFill(Color.WHITE);
        text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);
        text1.setY(text1.getLayoutBounds().getHeight());

        Text text2 = new Text(text1.getText());
        text2.setFont(Font.font(18));
        text2.setFill(Color.WHITE);
        text2.setX(10);
        text2.setY(CARD_HEIGHT - 10);
    }

    public String toString() {
        return (farbe + " " + Integer.toString(zahl));
    }

    }

