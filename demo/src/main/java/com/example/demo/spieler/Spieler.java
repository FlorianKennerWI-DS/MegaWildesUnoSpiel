package com.example.demo.spieler;


import com.example.demo.Karten.Karte;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import java.util.ArrayList;
import com.example.demo.Karten.Karte;
public class Spieler {
    //Handkarten aus Klasse Karten
    ArrayList<ArrayList<Karte>> handkarten = new ArrayList<ArrayList<Karte>>();
    String name;

    public String getName() {
        return name;
    }

    public Spieler () {
        for (int i = 0; i<5;i++) {
            handkarten.add(new ArrayList<Karte>());
        }
    }

    public ArrayList<ArrayList<Karte>> getHandkarten() {
        return handkarten;
    }

    public void ziehen(Karte karte) {   //Zahlen mit Sortieralgorithmen
        if (karte.getFarbe().equals("Rot")) {
            handkarten.get(0).add(karte);
        }
        if (karte.getFarbe().equals("Blau")) {
            handkarten.get(1).add(karte);
        }
        if (karte.getFarbe().equals("Gelb")) {
            handkarten.get(2).add(karte);
        }
        if (karte.getFarbe().equals("Gruen")) {
            handkarten.get(3).add(karte);
        }
        if (karte.getFarbe().equals("Schwarz")) {
            handkarten.get(4).add(karte);
        }
    }

    public void ablegen(Karte karte) {
        //handkarten.remove(karte.getFarbe(), karte);
        if (karte.getFarbe().equals("Rot")) {
            handkarten.remove(karte);
        }
    }

    public boolean hatKarten(){
        if (handkarten.size() == 0){
            return false;
        }
        else return true;
    }
}
}
