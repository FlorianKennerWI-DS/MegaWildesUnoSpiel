package com.example.demo.spieler;

import com.example.demo.Karten.Karte;

import java.util.ArrayList;
import com.example.demo.Karten.Karte;
public class Spieler {
    //Handkarten aus Klasse Karten?
    ArrayList<Karte> handkarten = new ArrayList<Karte>(); // zu Anfang 7 aber theoretisch unbegrenzt

    public void ziehen(Karte karte) {
        handkarten.add(karte);   // Methode nehmen in Klammern aufrufen
    }

    public void ablegen(Karte karte) {
        handkarten.remove(karte);    // Stelle oder Inhalt in Klammern -> Methode aufrufen
    }

    public boolean hatKarten(){
        if (handkarten.size() == 0){
            return false;
        }
        else return true;
    }
}
