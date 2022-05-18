package com.example.demo;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Card extends Parent {

    private static final int CARD_WIDTH = 100;
    private static final int CARD_HEIGHT = 140;

    enum Color {
        RED, BLUE, YELLOW, GREEN, BLACK;

        /*final Image image;

        color() {
            this.image = new Image(Card.class.getResourceAsStream("images/".concat(name().toLowerCase()).concat(".png")),
                    32, 32, true, true);
        }*/
    }

    enum Rank {
        ZERO(0),ONE(1),TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10)

        final int value;
        Rank(int value) {
            this.value = value;
        }

        String displayName() {
            return ordinal() < 9 ? String.valueOf(value) : name().substring(0, 1);
        }
    }

    public final Color color;
    public final Rank rank;
    public final int value;

    public Card(Color color, Rank rank) {
        this.color = color;
        this.rank = rank;
        this.value = rank.value;

        Rectangle bg = new Rectangle(CARD_WIDTH, CARD_HEIGHT);
        bg.setArcWidth(20);
        bg.setArcHeight(20);
        bg.setFill(javafx.scene.paint.Color.WHITE);

        Text text1 = new Text(rank.displayName());
        text1.setFont(Font.font(18));
        text1.setX(CARD_WIDTH - text1.getLayoutBounds().getWidth() - 10);
        text1.setY(text1.getLayoutBounds().getHeight());

        Text text2 = new Text(text1.getText());
        text2.setFont(Font.font(18));
        text2.setX(10);
        text2.setY(CARD_HEIGHT - 10);

        /*ImageView view = new ImageView(color.image);
        view.setRotate(180);
        view.setX(CARD_WIDTH - 32);
        view.setY(CARD_HEIGHT - 32);

        getChildren().addAll(bg, new ImageView(color.image), view, text1, text2);*/
        getChildren().addAll(bg, text1, text2);
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + color.toString();
    }
}


