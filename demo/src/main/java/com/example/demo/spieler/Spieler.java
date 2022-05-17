package com.example.demo.spieler;

import java.util.ArrayList;

public class Spieler {
    //Handkarten aus Klasse Karten?
    ArrayList<Karte> handkarten = new ArrayList<Karte>(); // zu Anfang 7 aber theoretisch unbegrenzt

    public void ziehen(Karte karte) {
        handkarten.add(karte);   // Methode nehmen in Klammern aufrufen
    }

    public void ablegen(Karte karte) {
        handkarten.remove(karte);    // Stelle oder Inhalt in Klammern -> Methode aufrufen
    }
}
