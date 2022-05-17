package com.example.demo.spieler;

import java.util.ArrayList;

public class Spieler {
    //Handkarten aus Klasse Karten?
    ArrayList<Karte> handkarten = new ArrayList<Karte>(); // zu Anfang 7 aber theoretisch unbegrenzt

    //ziehen
    public void ziehen(Spieler spieler) {
        spieler.handkarten.add();   // neue Karte in Klammern
    }
    //ablegen
    public void ablegen(Spieler spieler, Karte karte) {
        spieler.handkarten.remove(karte);    // Stelle oder Inhalt in Klammern
    }
}
