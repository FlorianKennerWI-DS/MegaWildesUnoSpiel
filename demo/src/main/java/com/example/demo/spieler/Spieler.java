package com.example.demo.spieler;

import com.example.demo.karten.Karte;
import java.util.ArrayList;
import java.util.HashMap;

// annika und Florian
public class Spieler {
    private String name;
    //Handkarten aus Klasse Karten
    private ArrayList<Karte> handkartenArrayList = new ArrayList<Karte>();
    public HashMap<String, HashMap<Integer, ArrayList<Karte>>> handkarten = new HashMap<String, HashMap<Integer, ArrayList<Karte>>>();

    public String getName() {
        return name;
    }

    public ArrayList<Karte> getHandkartenArrayList() {
        return handkartenArrayList;
    }
    public HashMap<String, HashMap<Integer, ArrayList<Karte>>> getHandkarten() {
        return handkarten;
    }

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
        handKartenToArrayList();
    }

    public Karte ablegen(Karte karte) {

        Karte abgelegteKarte = handkarten.get(karte.getFarbe()).get(karte.getZahl()).get(0);
        handkarten.get(karte.getFarbe()).get(karte.getZahl()).remove(0);
        handKartenToArrayList();
        System.out.println(getHandkartenArrayList());
        handKartenToArrayList();
        System.out.println(getName() + " legt " + karte.toString());
        return abgelegteKarte;
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

    public int kartenZaehlen(){
        int anzahlKarten = 0;
        for (var entry : handkarten.entrySet()){
            for (var secondEntry : entry.getValue().entrySet()){
                if (secondEntry.getValue().size() != 0){
                    anzahlKarten = anzahlKarten + secondEntry.getValue().size();
                }
            }
        }
        return anzahlKarten;
    }

    public void handKartenToArrayList(){
        handkartenArrayList.clear();
        for (var entry : handkarten.entrySet()){
            for (var secondEntry : entry.getValue().entrySet()){
                for (int i = 0; i < secondEntry.getValue().size(); i ++){
                    handkartenArrayList.add(secondEntry.getValue().get(i));
                }
            }
        }}
}

