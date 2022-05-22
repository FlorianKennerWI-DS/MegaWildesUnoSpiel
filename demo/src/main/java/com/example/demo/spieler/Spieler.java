package com.example.demo.spieler;

import com.example.demo.karten.Karte;
import java.util.ArrayList;
import java.util.HashMap;

public class Spieler {
    public String name;
    //Handkarten aus Klasse Karten
    public HashMap<String, HashMap<Integer, ArrayList<Karte>>> handkarten = new HashMap<String, HashMap<Integer, ArrayList<Karte>>>();

    public Spieler (String name) {
        this.name = name;

        handkarten.put("Blau", new HashMap<Integer, ArrayList<Karte>>());
        handkarten.put("Gruen", new HashMap<Integer, ArrayList<Karte>>());
        handkarten.put("Rot", new HashMap<Integer, ArrayList<Karte>>());
        handkarten.put("Gelb", new HashMap<Integer, ArrayList<Karte>>());
        handkarten.put("Schwarz", new HashMap<Integer, ArrayList<Karte>>());
    }

    public void ziehen(Karte karte) {

        if (!handkarten.get(karte.getFarbe()).containsKey(karte.getZahl())) {
            handkarten.get(karte.getFarbe()).put(karte.getZahl(), new ArrayList<Karte>());
        }
        handkarten.get(karte.getFarbe()).get(karte.getZahl()).add(karte);
    }

    public Karte ablegen(Karte karte) {

        Karte abgelegteKarte = handkarten.get(karte.getFarbe()).get(karte.getZahl()).get(0);
        handkarten.get(karte.getFarbe()).get(karte.getZahl()).remove(0);
        return abgelegteKarte;
    }

    public HashMap<String, HashMap<Integer, ArrayList<Karte>>> getHandkarten() {
        return handkarten;
    }

    public boolean hatKarten(){

        for (var entry : handkarten.entrySet()){
            for (var secondEntry : entry.getValue().entrySet()){
                if (secondEntry.getValue().size() != 0){
                    return true;
                }
            }
        }
        return  false;
    }
}

