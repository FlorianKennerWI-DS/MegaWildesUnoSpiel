package com.example.demo.spieler;

public class Computer extends Spieler {

    public void karteFinden() {
        // alle durchgehen
        if(obersteKarte.getFarbe().equals(handkarten.firstKey())) {
            ablegen(handkarten.get());
        }
    }
}
