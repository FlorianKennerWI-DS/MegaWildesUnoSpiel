package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class UpdateThread extends Thread{
    private Node node = null;

    public UpdateThread(Node node) {
        this.node = node;
    }

    public void run(ActionEvent e) {
        Platform.runLater(()-> {
            System.out.println(e);
        });
    }
}
