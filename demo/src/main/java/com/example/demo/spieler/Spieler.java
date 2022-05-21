package com.example.demo.spieler;

import com.example.demo.Karten.Karte;
import java.util.ArrayList;
import com.example.demo.spieler.HandkartenSortierung;

public class Spieler {
    //Handkarten aus Klasse Karten
    ArrayList<ArrayList<Karte>> handkarten = new ArrayList<ArrayList<Karte>>();

    public Spieler () {
        for (int i = 0; i<5;i++) {
            handkarten.add(new ArrayList<Karte>());
        }
    }

    public void ziehen(Karte karte) {   //Zahlen mit Sortieralgorithmen
        if (karte.getFarbe().equals("Rot")) {
            handkarten.get(0).add(karte);
            HandkartenSortierung.sort(handkarten.get(0));
        }
        if (karte.getFarbe().equals("Blau")) {
            handkarten.get(1).add(karte);
            HandkartenSortierung.sort(handkarten.get(1));
        }
        if (karte.getFarbe().equals("Gelb")) {
            handkarten.get(2).add(karte);
            HandkartenSortierung.sort(handkarten.get(2));
        }
        if (karte.getFarbe().equals("Gruen")) {
            handkarten.get(3).add(karte);
            HandkartenSortierung.sort(handkarten.get(3));
        }
        if (karte.getFarbe().equals("Schwarz")) {
            handkarten.get(4).add(karte);
            HandkartenSortierung.sort(handkarten.get(4));
        }
    }

    public void ablegen(Karte karte) {
        if (karte.getFarbe().equals("Rot")) {
            handkarten.get(0).remove(karte);
        }
        if (karte.getFarbe().equals("Blau")) {
            handkarten.get(1).remove(karte);
        }
        if (karte.getFarbe().equals("Gelb")) {
            handkarten.get(2).remove(karte);
        }
        if (karte.getFarbe().equals("Gruen")) {
            handkarten.get(3).remove(karte);
        }
        if (karte.getFarbe().equals("Schwarz")) {
            handkarten.get(4).remove(karte);
        }
    }

    public boolean hatKarten(){
        if (handkarten.size() == 0){
            return false;
        }
        else return true;
    }
}

