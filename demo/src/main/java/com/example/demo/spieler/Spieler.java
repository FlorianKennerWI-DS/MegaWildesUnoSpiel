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
    ArrayList<Karte> rot = new ArrayList<Karte>();
    ArrayList<Karte> blau = new ArrayList<Karte>();
    ArrayList<Karte> gelb = new ArrayList<Karte>();
    ArrayList<Karte> gruen = new ArrayList<Karte>();
    ArrayList<Karte> schwarz = new ArrayList<Karte>();
    ArrayList<ArrayList<Karte>> handkarten = new ArrayList<ArrayList<Karte>>();
    handkarten.add(schwarz);
    public void ziehen(Karte karte) {   //Zahlen mit Sortieralgorithmen
        if (karte.getFarbe().equals("Rot")) {
            handkarten.get(rot).add(karte);
        }
        if (karte.getFarbe().equals("Blau")) {
            blau.add(karte.getZahl());
            handkarten.add(blau);
        }
        if (karte.getFarbe().equals("Gelb")) {
            gelb.add(karte.getZahl());
            handkarten.add(gelb);
        }
        if (karte.getFarbe().equals("Gruen")) {
            gruen.add(karte.getZahl());
            handkarten.add(gruen);
        }
        if (karte.getFarbe().equals("Schwarz")) {
            schwarz.add(karte.getZahl());
            handkarten.add(schwarz);
        }
    }

    public void ablegen(Karte karte) {
        //handkarten.remove(karte.getFarbe(), karte);
        if (karte.getFarbe().equals("Rot")) {
            handkarten.get(rot).remove(karte);
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
